package com.mz.youchat.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.mz.youchat.comm.HttpUrl;
import com.mz.youchat.model.User;
import com.mz.youchat.utils.HttpUtils;
import com.mz.youchat.utils.Result;
import com.mz.youchat.utils.StringUtils;


public class UserService {
	
	/**
	 * 用户登录
	 * @param username 邮箱|手机号
	 * @param password
	 * @return
	 */
    public static Result<User> login(String username, String password){
    	User user = new User();
    	user.setNickName(username);
    	user.setPwd(password);
        return HttpUtils.postJsonRetObj(User.class, HttpUrl.LOGIN, user.toJsonObj());
    }
    
    /**
     * 用户（手机号|邮箱）注册 
     * 
     * @param user
     * @return
     */
    public static Result<User> register(User user){
    	
    	Result<User> uResult = new Result<User>();
    	JSONObject params = new JSONObject();
    	
    	try {
			if(user.getPhone() != null){
				params.put("type", "sms");
				params.put("email_phone", user.getPhone());
			}else if(user.getEmail() != null){
				params.put("type", "email");
				params.put("email_phone", user.getEmail());
			}
			params.put("password", user.getPwd());
		} catch (JSONException e) {
		}
    	
    	Result<Void> result = HttpUtils.postJsonWithoutRet(HttpUrl.REGISTER, user.toJsonObj());
    	
    	if (result.isSuccess()) {
			String uid = result.getAttr().toString();
			if (!StringUtils.isEmpty(uid)) {
				return info(uid);
			}else{
				uResult.setSuccess(false);
				uResult.setMsg("注册失败");
			}
		}else{
			uResult.setSuccess(false);
			uResult.setMsg(result.getMsg());
		}
    	return uResult;
    }
    
    /**
     * 读取用户详细信息
     * @param uid
     * @return
     */
    public static Result<User> info(String uid)
    {
    	User user = new User();
    	user.setUid(uid);
    	return HttpUtils.postJsonRetObj(User.class, HttpUrl.USER_INFO,user.toJsonObj());
    }
}
