package com.mz.youchat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: Lusar
 * Date: 13-11-10
 * Time: 下午2:52
 */
public class HttpUtils {
    private static final String MSG      =   "msg";
    private static final String SUCCESS  =   "success";
    private static final String ARRAY	 = 	 "array";
    private static final String TAG      =   HttpUtils.class.getSimpleName();

    public static JSONObject getRequest(String requestUrl){
        Log.d(TAG,"Get Url:"+requestUrl);

        JSONObject jsonObject = new JSONObject();
        try {
            URL                 url     =   new URL(requestUrl);            
            HttpURLConnection   conn    =   (HttpURLConnection)url.openConnection();
            
            conn.connect();
            int resultCode = conn.getResponseCode();
            Log.d(TAG,"req code = "+resultCode);
            
            if( resultCode == 200) {
                InputStream         is   =  conn.getInputStream();
                InputStreamReader   isr  =  new InputStreamReader(is,"UTF-8");
                BufferedReader      br   =  new BufferedReader(isr);
                StringBuilder       sb   =  new StringBuilder();
                String              line =  null;

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                 
                    Log.d(TAG,line);
                    Log.d(TAG,"line length = "+line.length());
                }
                br.close();

                Log.d(TAG,"return :"+sb.toString());
                Log.d(TAG,"return string length = "+sb.length());

                jsonObject = new JSONObject(sb.toString());
                jsonObject.put("success",true);
                jsonObject.put("msg","");
                
                return jsonObject;
            }else{
                jsonObject.put("success",false);
                jsonObject.put("msg","获取信息失败");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","MalformedURLException");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","UnsupportedEncodingException");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","IOException");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","JSONException");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        } catch(Exception e){
            Log.d(TAG, e.getMessage());
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","操作异常");
            } catch (JSONException e1) {
            }
        }
        return jsonObject;
    }

    
    public static JSONObject postJson(String url, JSONObject params) {
        Log.d(TAG,String.format("postJson:\nrequset:%s \nparams: %s", url, params.toString()));
        JSONObject jsonObject = new JSONObject();
        try {
            HttpClient  client     = new DefaultHttpClient();
            HttpPost    post       = new HttpPost(url);
            post.setHeader("Content-type", "application/json");
            StringEntity se        = new StringEntity(params.toString(),"utf-8");
            post.setEntity(se);
            //Represents a collection of HTTP protocol and framework parameters
            HttpParams  httpParams = client.getParams();
            //set timeout
            HttpConnectionParams.setConnectionTimeout(httpParams, 5000);     //链接超时
            HttpConnectionParams.setSoTimeout(httpParams, 35000);             //响应超时
            Log.d(TAG,"execute http post request");
            HttpResponse response    = client.execute(post);

            int code                = response.getStatusLine().getStatusCode();
            Log.d(TAG,"request code = "+code);
            if(code != 200){
                jsonObject.put("success",false);
                if(code == 500){
                    jsonObject.put("msg","服务器端出现异常");
                }else{
                    jsonObject.put("msg","传递参数不正确");
                }
                Log.e("TAG", jsonObject.toString());
                return jsonObject;
            }
            Log.d(TAG,"here now----");
            String ret = EntityUtils.toString(response.getEntity());
                   //ret = URLDecoder.decode(ret, "utf-8");

            Log.d(TAG,"return str:"+ret);
            jsonObject =  new JSONObject(ret);
            Log.d(TAG,String.format("return json:%s",jsonObject.toString()));
        } catch(ConnectTimeoutException e){
            Log.d(TAG, e.getMessage());
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","请求超时");
            } catch (JSONException e1) {
            }
        } catch(JSONException e) {
            Log.d(TAG, e.getMessage());
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","json数据解析出错");
            } catch (JSONException e1) {
            }
        }catch(Exception e){
            //Log.d(TAG, e.getMessage());
            try {
                jsonObject.put("success",false);
                jsonObject.put("msg","操作异常");
            } catch (JSONException e1) {
            }
        }
        return jsonObject;
    }

    /**
     * 获取对象列表
     * @param c
     * @param url
     * @param params
     * @param field
     * @param <T>
     * @return
     */
    public static Result<Void> postJsonWithoutRet( String url, JSONObject params){
        Result<Void> result = new Result<Void>();
        JSONObject jsonObject = HttpUtils.postJson(url, params);
        Log.e("return json", jsonObject.toString());
        try {
            if( ! jsonObject.isNull(MSG)){ result.setMsg(jsonObject.getString(MSG)); }
            if( ! jsonObject.isNull(SUCCESS)){ result.setSuccess(jsonObject.getBoolean(SUCCESS)); }
        } catch (JSONException e) {
        	result.setSuccess(false);
        	result.setMsg("json 数据出错啦");
        }
        return result;
    }
    
    /**
     * 获取对象列表
     * @param c
     * @param url
     * @param params
     * @param field
     * @param <T>
     * @return
     */
    public static<T extends IJson> Result<T> postJsonRetObj(Class<T> c, String url, JSONObject params){
        Result<T> result = new Result<T>();
        JSONObject jsonObject = HttpUtils.postJson(url, params);
        Log.e("return json", jsonObject.toString());
        try {
            if( ! jsonObject.isNull(MSG)){ result.setMsg(jsonObject.getString(MSG)); }
            if( ! jsonObject.isNull(SUCCESS)){ result.setSuccess(jsonObject.getBoolean(SUCCESS)); }
          
            T t = c.newInstance();
            t.readFrom(jsonObject);
            result.setReturnObj(t);
        } catch (JSONException e) {
        	result.setSuccess(false);
        	result.setMsg("json 数据出错啦");
        } catch (InstantiationException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg("创建返回值对象出错啦");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg("创建返回值对象出错啦");
        }
        return result;
    }


    /**
     * 获取对象列表
     * @param c
     * @param url
     * @param params
     * @param field
     * @param <T>
     * @return
     */
    public static<T extends IJson> Result<List<T>> getList(Class<T> c, String url, JSONObject params){
        Result<List<T>> lResult = new Result<List<T>>();
        JSONObject jsonObject = HttpUtils.postJson(url, params);
        Log.e("return json", jsonObject.toString());
        try {
            if( ! jsonObject.isNull(MSG)){ lResult.setMsg(jsonObject.getString(MSG)); }
            if( ! jsonObject.isNull(SUCCESS)){ lResult.setSuccess(jsonObject.getBoolean(SUCCESS)); }
            if( ! lResult.isSuccess()){  return lResult;    }
            if( jsonObject.isNull(ARRAY)){
                lResult.setSuccess(false);
                lResult.setMsg("返回的json字符串缺少"+ARRAY+"字段域");
                return lResult;
            }
            JSONArray array = jsonObject.getJSONArray(ARRAY);
            List<T> tList =  new ArrayList<T>(array.length());
            for(int idx = 0; idx < array.length(); idx++){
                T t = c.newInstance();
                t.readFrom(array.getJSONObject(idx));
                tList.add(t);
            }
            lResult.setReturnObj(tList);
        } catch (JSONException e) {
            lResult.setSuccess(false);
            lResult.setMsg("json 数据出错啦");
        } catch (InstantiationException e) {
            e.printStackTrace();
            lResult.setSuccess(false);
            lResult.setMsg("创建返回值对象出错啦");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            lResult.setSuccess(false);
            lResult.setMsg("创建返回值对象出错啦");
        }
        return lResult;
    }

}
