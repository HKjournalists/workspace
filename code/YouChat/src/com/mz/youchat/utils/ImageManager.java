package com.mz.youchat.utils;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;


/**
 * Created by lusar on 1/22/14.
 * 使用前，必须先进行一次init操作。
 */
public class ImageManager {
    private static 		    ImageManager sinstance;
    private static          Context      scontext;

    private ImageManager(){
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(scontext)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    public synchronized static ImageManager getInstance(){
        if(sinstance==null){
            synchronized (ImageManager.class){
               sinstance = new ImageManager();
            }
        }
        return sinstance;
    }

    /**
     * 初始化图片加载器
     * @param context
     */
    public static void init(Context context){
        scontext = context;
        getInstance();
    }

    /**
     * 加载图片
     * @param imageUrl   图片路径
     * @param imageView  显示视图
     * @param defaultImageId 默认显示图片的资源id， 不需要时，设置为NULL即可。
     */
    public void get(String imageUrl, ImageView imageView, final Integer defaultImageId){
        imageView.setImageResource(defaultImageId);
        if(StringUtils.isBlank(imageUrl)){
            return ;
        }
        ImageLoader.getInstance().displayImage(imageUrl, imageView, getImageLoadOptoins(defaultImageId));
    }


    /**
     * 清除缓存
     */
   public void clear(){
	   ImageLoader.getInstance().clearDiscCache();
       ImageLoader.getInstance().clearMemoryCache();
   }

    private static DisplayImageOptions getImageLoadOptoins(int defaultImgId){
        return
                new DisplayImageOptions.Builder()
                .showImageForEmptyUri(defaultImgId)
                .showImageOnFail(defaultImgId)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .considerExifParams(true)
                .build();
    }
}

