package com.mz.youchat;

import java.util.HashMap;
import java.util.UUID;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

import com.mz.youchat.utils.DbLoader;
import com.mz.youchat.utils.DensityUtil;
import com.mz.youchat.utils.DeviceUuidFactory;
import com.mz.youchat.utils.ImageManager;
import com.mz.youchat.utils.SharedPreferenceUtils;


public class YouChatApp extends Application {
	private static HashMap<String, Object> sMap = new HashMap<String ,Object>();
	
	private static YouChatApp instance;

	//设备唯一ID
	private static UUID uuid;



	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		if (uuid == null) {
            DeviceUuidFactory df = new DeviceUuidFactory(getApplicationContext());
			uuid = df.getUID();
		}
        globalInit();
	}

    private void globalInit(){
        ImageManager.init(getApplicationContext());
        DbLoader.init(getApplicationContext());
        SharedPreferenceUtils.init(getApplicationContext());
        DensityUtil.init(getApplicationContext());
    }

    public Context getContext(){
        return getApplicationContext();
    }

    public static YouChatApp getInstance() {
		return instance;
	}
	
	public static UUID getUuid()
	{
		return uuid;
	}
	
	/**
	 * 存入Key-Value
	 * @param key
	 * @param value
	 */
	public static void store(String key, Object value){
		sMap.put(key, value);
	}
	/**
	 * 提取存储的对象
	 * @param key
	 * @return
	 */
	public static Object withdraw(String key){
		Object obj = sMap.get(key);
		sMap.remove(key);
		return obj;
	}
	
	/**
	 * 提取对象，不从存储池中删除
	 * @param key
	 * @return
	 */
	public static Object getObject(String key){
		return isContain(key) ? sMap.get(key) : null;
	}
	
	/**
	 * 判断Key是否存在
	 * @param key
	 * @return
	 */
	public static boolean isContain(String key){
		return sMap.containsKey(key);
	}
	
	public static String getVerName()
	{
		String verName = "";
		try {
			verName = getInstance().getPackageManager().getPackageInfo("com.mz.youchat", 0).versionName;
		} catch (NameNotFoundException e) {
		}
		return verName;
	}
}
