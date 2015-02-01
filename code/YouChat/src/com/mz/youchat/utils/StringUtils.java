package com.mz.youchat.utils;

import java.util.Random;

import org.json.JSONArray;

/**
 * Created with IntelliJ IDEA.
 * User: Lusar
 * Date: 13-11-10
 * Time: ??????3:26
 */
public class StringUtils {


    public static boolean isEmpty(String str){
        return isBlank(str);
    }

	/**
	 * ??????????????????????????????
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str)
	{
		if(StringUtils.isBlank(str)) return false;
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	/**
     * ??????????????????????????????.
     * @param str
     * @return   ???????????? str????????????????????????true.
     */
    public static boolean isBlank(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }
        return false;
    }
    
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     } 

    public static String parseJSONArraytoString(JSONArray array) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < array.length(); i++) {
            try {
                str = str.append(array.getString(i)).append(" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str.toString();
    }
}
