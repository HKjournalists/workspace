package com.mz.youchat.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created with IntelliJ IDEA.
 * User: Sar
 * Date: 13-10-25
 * Time: ??????11:32
 * <p>??????????????????????????????init??????</p>
 */
public class SharedPreferenceUtils {
    private static final String 		DB_NAME = "idoukou_db";
    private static final String 		EMPTY_STRING = "";
    private static SharedPreferences 	preferences;

    public static  void init(Context context){
        preferences = context.getSharedPreferences(DB_NAME,Context.MODE_PRIVATE);
    }

    public static boolean contain(String key){
        return preferences.contains(key);
    }

    public static String getString(String key){
        if(! contain(key)){
            return null;
        }
        return preferences.getString(key,EMPTY_STRING);
    }

    public static Boolean getBoolean(String key){
        if(! contain(key)){
            return null;
        }
        return preferences.getBoolean(key,false);
    }
    public static Integer getInt(String key){
        if(! contain(key)){
            return null;
        }
        return preferences.getInt(key,0);
    }

    public static void store(String key ,String value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


    public static void store(String key, Boolean flag){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, flag);
        editor.commit();
    }
    public static void clear(String key){
    	 SharedPreferences.Editor editor = preferences.edit();
    	 editor.remove(key);
    }
    
    public static void remove(String key){
    	SharedPreferences.Editor editor = preferences.edit();
    	editor.remove(key).commit();
    }
}
