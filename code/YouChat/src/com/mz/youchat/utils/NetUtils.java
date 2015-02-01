package com.mz.youchat.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by lusar on 4/8/14.
 */
public class NetUtils {

    /**
     * ??????wifi????????????
     * @param context
     * @return
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * ???????????????????????????
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * ??????????????????????????? -1??????????????? 1???WIFI??????2???wap??????3???net??????
     * @param context
     * @return
     */
    public static int getAPNType(Context context){
        int netType = -1;
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo==null){
            return netType;
        }
        int nType = networkInfo.getType();
        if(nType==ConnectivityManager.TYPE_MOBILE){
            Log.e("networkInfo.getExtraInfo()", "networkInfo.getExtraInfo() is " + networkInfo.getExtraInfo());
            if(networkInfo.getExtraInfo().toLowerCase().equals("cmnet")){
                netType = 3;
            }
            else{
                netType = 2;
            }
        }
        else if(nType==ConnectivityManager.TYPE_WIFI){
            netType = 1;
        }
        return netType;
    }

}
