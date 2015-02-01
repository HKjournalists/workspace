package com.mz.youchat.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by lusar on 1/25/14.
 */
@SuppressLint("SdCardPath")
public class DbLoader {
    private static volatile DbLoader sinstance;
    @SuppressWarnings("unused")
	private static final String rootDirectory      =   "/data/data/com.idoukou.thu/databases/";
    private static final String DATABASE_PATH      =   "/data/data/com.idoukou.thu/databases/";
    private static final String DATABASE_FILENAME  =   "idoukouarea.db";
    private static Context scontext;
    private AssetDatabaseOpenHelper openHelper;

    public static void init(Context context){
        scontext = context;

    }

    private DbLoader(){
        openHelper  = new AssetDatabaseOpenHelper(scontext, DATABASE_PATH + DATABASE_FILENAME);
    }

    public synchronized static DbLoader getInstance(){
        if(sinstance == null){
            synchronized (DbLoader.class){
                sinstance = new DbLoader();
            }
        }
        return sinstance;
    }

    public synchronized SQLiteDatabase getReadableDatabase(){
        return  openHelper.getReadableDatabase();
    }
    public synchronized SQLiteDatabase getWritableDatabase(){
        return  openHelper.getWritableDatabase();
    }
}
