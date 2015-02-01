package com.mz.youchat.utils;


import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressLint("SimpleDateFormat")
public class DateUtils {

	/**
	 * ???????????????????????????Date (?????????2010-07-27 21:30:00)
	 * @param s 
	 * @return
	 */
	public static Date yyyy_MM_dd_HH_mm_ss2Date(String s){
		DateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date restDate=null;
		try {
			restDate = formate.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return restDate;
	}
	/**
	 * ?????????Date
	 * @param str ??????20100206
	 * @return
	 */
	public static Date yyyyMMdd2Date(String str){
		DateFormat formate = new SimpleDateFormat("yyyyMMdd");
		Date restDate=null;
		try {
			restDate = formate.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return restDate;
	}
	/**
	 * ???????????????
	 * @param date
	 * @return
	 */
	public static String MM_dd_HH_mm(Date date){
		DateFormat format = new SimpleDateFormat("MM-dd HH:mm");
		return format.format(date);
	}
	
	/**
	 * ????????????: ?????????????????????????????????<br/> 
	 * @param date
	 * @return 
	 * @author shixiangjian
	 * ??????:Apr 24, 2012 2:33:16 PM
	 */
	public static String yyyy_MM_dd(Date date){
		if(date==null){
			return "";
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static Date yyyy_MM_dd_2_Date(String date){
		if(date==null || date.trim().length()==0){
			return null;
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 *Description : ???????????????(???2009-01-02 10:11:11)
	 *@param date
	 *@return
	 */
	public static String yyyy_MM_dd_HH_mm_ss(Date date){
		if(date==null){
			return "";
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	
	@SuppressWarnings("deprecation")
	public static Integer getAge(Date date){
		if(date == null){
			return null;
		}
		int year = date.getYear();
		Date nowDate = new Date();
		return nowDate.getYear() - year + 1;
	}

    /**
     *
     *Description : ???????????????(???2009???01???02??? 10???11???)
     *@param date
     *@return
     */
    public static String yyyy_MM_dd_HH_mm(Date date){
        if(date==null){
            return "";
        }
        DateFormat format = new SimpleDateFormat("yyyy???MM???dd??? HH???mm???");
        return format.format(date);
    }


    /**
     * ??????????????????
     * @param dateStri
     * @return   ???????????????????????????hh_mm ????????? ??????????????????yyyy-hh-mm
     */
    public static String getSimpleDateyyyy_hh_mmOrhh_mm(String dateStri){
        String nowDate = yyyy_MM_dd(new Date());
        if(dateStri==null){
            return "";
        }
        if(dateStri.startsWith(nowDate) && dateStri.length()>10){
            return dateStri.substring(10);
        }else{
            return dateStri.substring(0,10);
        }
    }
	
	public static void main(String[] arags){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(yyyyMMdd2Date("19820426")));
	}
}
