package com.mz.youchat.utils;

import android.content.Context;

/**
 * Created by lusar on 3/9/14.
 */
public class DensityUtil {
    public static Context context;

    public static void init(Context ctx){
        context = ctx;
    }

    /**
     * ??????????????????????????? dp ????????? ????????? px(??????)
     */
    public static int dip2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * ??????????????????????????? px(??????) ????????? ????????? dp
     */
    public static int px2dip(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
