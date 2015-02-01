package com.mz.youchat.utils;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: Lusar
 * Date: 13-11-10
 * Time: ??????3:22
 */
public interface IJson {
    /**
     * ??????jsonObj??????
     * @return  JSONObject
     */
    public JSONObject toJsonObj();

    /**
     * ???JSONObj????????????.
     * @param jsonObject
     */
    public void readFrom(JSONObject jsonObject)throws JSONException;
}
