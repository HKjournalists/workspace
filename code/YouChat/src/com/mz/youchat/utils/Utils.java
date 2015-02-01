package com.mz.youchat.utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {
	
	public static final String RESPONSE_METHOD = "method";
    public static final String RESPONSE_CONTENT = "content";
    public static final String RESPONSE_ERRCODE = "errcode";
    protected static final String ACTION_LOGIN = "com.baidu.pushdemo.action.LOGIN";
    public static final String ACTION_MESSAGE = "com.baiud.pushdemo.action.MESSAGE";
    public static final String ACTION_RESPONSE = "bccsclient.action.RESPONSE";
    public static final String ACTION_SHOW_MESSAGE = "bccsclient.action.SHOW_MESSAGE";
    protected static final String EXTRA_ACCESS_TOKEN = "access_token";
    public static final String EXTRA_MESSAGE = "message";

    public static String logStringCache = "";

    public static List<String> getTagsList(String originalText) {
        if (originalText == null || originalText.equals("")) {
            return null;
        }
        List<String> tags = new ArrayList<String>();
        int indexOfComma = originalText.indexOf(',');
        String tag;
        while (indexOfComma != -1) {
            tag = originalText.substring(0, indexOfComma);
            tags.add(tag);

            originalText = originalText.substring(indexOfComma + 1);
            indexOfComma = originalText.indexOf(',');
        }

        tags.add(originalText);
        return tags;
    }

    public static String getLogText(Context context) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sp.getString("log_text", "");
    }

    public static void setLogText(Context context, String text) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        Editor editor = sp.edit();
        editor.putString("log_text", text);
        editor.commit();
    }
    public static void setBind(Context context, boolean flag) {
        String flagStr = "not";
        if (flag) {
            flagStr = "ok";
        }
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        Editor editor = sp.edit();
        editor.putString("bind_flag", flagStr);
        editor.commit();
    }
	// ??????ApiKey
    public static String getMetaValue(Context context, String metaKey) {
        Bundle metaData = null;
        String apiKey = null;
        if (context == null || metaKey == null) {
            return null;
        }
        try {
            ApplicationInfo ai = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            if (null != ai) {
                metaData = ai.metaData;
            }
            if (null != metaData) {
                apiKey = metaData.getString(metaKey);
            }
        } catch (NameNotFoundException e) {

        }
        return apiKey;
    }
    
	// ???share preference????????????????????????????????????ionBind??????????????????true???unBind??????????????????false
    public static boolean hasBind(Context context) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        String flag = sp.getString("bind_flag", "");
        if ("ok".equalsIgnoreCase(flag)) {
            return true;
        }
        return false;
    }
    
	/**
	 * Hides the input method.
	 * 
	 * @param context
	 *            context
	 * @param view
	 *            The currently focused view
	 * @return success or not.
	 */
	public static boolean hideInputMethod(Context context, View view) {
		if (context == null || view == null) {
			return false;
		}

		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null) {
			return imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}

		return false;
	}

	/**
	 * Show the input method.
	 * 
	 * @param context
	 *            context
	 * @param view
	 *            The currently focused view, which would like to receive soft
	 *            keyboard input
	 * @return success or not.
	 */
	public static boolean showInputMethod(Context context, View view) {
		if (context == null || view == null) {
			return false;
		}

		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null) {
			return imm.showSoftInput(view, 0);
		}

		return false;
	}

	public static float pixelToDp(Context context, float val) {
		float density = context.getResources().getDisplayMetrics().density;
		return val * density;
	}

	public static int dipToPx(Context context, int dipValue) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dipValue, context.getResources().getDisplayMetrics());
	}

	public static String getHashedFileName(String url) {
		if (url == null || url.endsWith("/")) {
			return null;
		}

		String suffix = getSuffix(url);
		StringBuilder sb = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] dstbytes = digest.digest(url.getBytes("UTF-8")); // GMaFroid
																	// uses
																	// UTF-16LE
			sb = new StringBuilder();
			for (int i = 0; i < dstbytes.length; i++) {
				sb.append(Integer.toHexString(dstbytes[i] & 0xff));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != sb && null != suffix) {
			return sb.toString() + "." + suffix;
		}

		return null;
	}

	private static String getSuffix(String fileName) {
		int dot_point = fileName.lastIndexOf(".");
		int sl_point = fileName.lastIndexOf("/");
		if (dot_point < sl_point) {
			return "";
		}

		if (dot_point != -1) {
			return fileName.substring(dot_point + 1);
		}

		return null;
	}

	/**
	 * Indicates whether the specified action can be used as an intent. This
	 * method queries the package manager for installed packages that can
	 * respond to an intent with the specified action. If no suitable package is
	 * found, this method returns false.
	 * 
	 * @param context
	 *            The application's environment.
	 * @param intent
	 *            The Intent action to check for availability.
	 * 
	 * @return True if an Intent with the specified action can be sent and
	 *         responded to, false otherwise.
	 */
	public static boolean isIntentAvailable(Context context, Intent intent) {
		final PackageManager packageManager = context.getPackageManager();

		List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
				PackageManager.MATCH_DEFAULT_ONLY);

		return list.size() > 0;
	}

	public static Map<String, String> parseQueryString(String queryString) {
		Map<String, String> params = new HashMap<String, String>();
		if (queryString == null || queryString.isEmpty()) {
			return params;
		}
		int pos = queryString.indexOf('?');
		if (pos > -1) {
			String query = queryString.substring(pos + 1);
			queryString = queryString.substring(0, pos);
			for (String param : query.split("&")) {
				pos = param.indexOf("=");
				if (pos > -1) {
					params.put(param.substring(0, pos), param.substring(pos + 1));
				}
			}
		}
		return params;
	}
}
