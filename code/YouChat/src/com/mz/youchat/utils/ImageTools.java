package com.mz.youchat.utils;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lusar on 4/13/14.
 */
public class ImageTools {
    public static void saveBitmap(Bitmap bitmap, String filename) throws IOException
    {
        Log.d("lusar" , "save file path = "+filename);
        File file = new File(filename);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream out;
        try{
            out = new FileOutputStream(file);
            if(bitmap.compress(Bitmap.CompressFormat.PNG, 70, out))
            {
                out.flush();
                out.close();
            }
            Log.d("lusar", "write to file ok");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Log.d("lusar", "save image failed filenotfound exception. ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Log.d("lusar", "save image failed IOException exception. ");
        }
    }
}
