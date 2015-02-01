package com.mz.youchat.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;

public class QueryParams {

	public static Map<String, String> getParams(Object object){
		Class<?> class1 = object.getClass();
		Field fields[] = class1.getDeclaredFields();
		Map<String, String> params = new HashMap<String, String>();
		
		for (Field field : fields) {
			String name=field.getName();
			try {
				if(field.get(object) != null){
					Log.d("Query", field.get(object).toString());
					params.put(name, field.get(object).toString());
				}
				
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
		}

		return params;
	}
}
