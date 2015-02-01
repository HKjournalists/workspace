package com.mz.youchat.model;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import com.mz.youchat.utils.IJson;
import com.mz.youchat.utils.StringUtils;


/**
 * Created with IntelliJ IDEA.
 * User: Lusar
 * Date: 13-11-10
 * Time: 下午3:19
 */
public class User implements IJson,Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String     uid;            //uid
    private  String     phone;          //手机号码
    private  String 	email;			//E-MAIL
    private  String     password;       //密码
    private  String     nickName;       //昵称.
    private  String		sex;			//性别  
    private  String		location;       //所在地理位置名称。如：内蒙古 通辽。
    private  Double     latitude;
    private  Double     longitude;
    private  Double		distance;
    private	 String 	icon;			//用户头像
    
    
    private  String  	birthday;		//生日
    private  String     spaceicon;		//空间背景图
    private  String		intro;			//用户介绍
    private  String		qq;				
    private  String		weixin;			
    private  String		weibo;
    private  Integer	flowerNum;		//鲜花数
    private  Integer 	followingNum;	//关注数
    private  Integer	fanNum;			//粉丝数
    private  Integer	songNum;		//歌曲数量
    private  Integer	albumNum;		//专辑数量
    private  Integer	photoNum;		//图片数量
    
    
    private  Integer	activityNum;	//活动数量
    private  Integer	groupNum;		//圈子数量
    
    
    private Integer 	province;		//省
    private Integer 	city;			//市
    private Integer 	area;			//区
    
    
    private String      isFollowing; 	//是否关注 YES|NO
    private String		groupId;		//分组ID
    
    
    
    
    public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSpaceicon() {
		return spaceicon;
	}

	public void setSpaceicon(String spaceicon) {
		this.spaceicon = spaceicon;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public Integer getFlowerNum() {
		return flowerNum;
	}

	public void setFlowerNum(Integer flowerNum) {
		this.flowerNum = flowerNum;
	}

	public Integer getFollowingNum() {
		return followingNum;
	}

	public void setFollowingNum(Integer followingNum) {
		this.followingNum = followingNum;
	}

	public Integer getFanNum() {
		return fanNum;
	}

	public void setFanNum(Integer fanNum) {
		this.fanNum = fanNum;
	}

	public Integer getSongNum() {
		return songNum;
	}

	public void setSongNum(Integer songNum) {
		this.songNum = songNum;
	}

	public Integer getAlbumNum() {
		return albumNum;
	}

	public void setAlbumNum(Integer albumNum) {
		this.albumNum = albumNum;
	}

	public Integer getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(Integer photoNum) {
		this.photoNum = photoNum;
	}

	public Integer getActivityNum() {
		return activityNum;
	}

	public void setActivityNum(Integer activityNum) {
		this.activityNum = activityNum;
	}

	public Integer getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return password;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getIsFollowing() {
		return isFollowing;
	}

	public void setIsFollowing(String isFollowing) {
		this.isFollowing = isFollowing;
	}

	public JSONObject toJsonObj() {
    	 JSONObject jsonObject = new JSONObject();
         try {
         if( ! StringUtils.isBlank(uid)){ jsonObject.put("uid", uid); }
         if( ! StringUtils.isBlank(phone)){ jsonObject.put("phone", phone); }
         if( ! StringUtils.isBlank(password)){ jsonObject.put("password", password); }
         if( ! StringUtils.isBlank(nickName)){ jsonObject.put("nickname", nickName); }
         if( ! StringUtils.isBlank(location)){ jsonObject.put("location", location); }
         if( latitude != null){ jsonObject.put("latitude", latitude); }
         if( longitude != null){ jsonObject.put("longitude", longitude); }
         } catch (JSONException e) {
         }
         return jsonObject;
	}

	public void readFrom(JSONObject jsonObject) throws JSONException {
		
		 if( ! jsonObject.isNull("uid")){ this.uid = jsonObject.getString("uid"); }
		 if( ! jsonObject.isNull("icon")){ this.icon = jsonObject.getString("icon"); }
//		 if( ! jsonObject.isNull("sex")){ this.sex = jsonObject.getString("sex"); }
		 // modified by hcc
		 if( ! jsonObject.isNull("gender")){ 
			 this.sex = jsonObject.getString("gender"); 
		 }else if ( ! jsonObject.isNull("sex")){ 
			 this.sex = jsonObject.getString("sex"); 
		 }
	     if( ! jsonObject.isNull("phone")){ this.phone = jsonObject.getString("phone"); }
	     if( ! jsonObject.isNull("password")){ this.password = jsonObject.getString("password"); }
	     if( ! jsonObject.isNull("nickname")){ this.nickName = jsonObject.getString("nickname"); }
	     if( ! jsonObject.isNull("name")){ this.nickName = jsonObject.getString("name"); }
	     if( ! jsonObject.isNull("latitude")){ this.latitude = jsonObject.getDouble("latitude"); }
	     if( ! jsonObject.isNull("longitude")){ this.longitude = jsonObject.getDouble("longitude"); }
	     if( ! jsonObject.isNull("location")){ this.location = jsonObject.getString("location"); }
	     if( ! jsonObject.isNull("isFollowing")){ this.isFollowing = jsonObject.getString("isFollowing"); }
	     if( ! jsonObject.isNull("groupId")){ this.groupId = jsonObject.getString("groupId"); }
	     if( ! jsonObject.isNull("distance")){ this.distance = jsonObject.getDouble("distance"); }
	     
	     
	     if( ! jsonObject.isNull("birthday")){ this.birthday = jsonObject.getString("birthday"); }
	     
	     if( ! jsonObject.isNull("spaceicon")){ this.spaceicon = jsonObject.getString("spaceicon"); }
	     if( ! jsonObject.isNull("qq")){ this.qq = jsonObject.getString("qq"); }
	     if( ! jsonObject.isNull("intro")){ this.intro = jsonObject.getString("intro"); }
	     if( ! jsonObject.isNull("weixin")){ this.weixin = jsonObject.getString("weixin"); }
	     if( ! jsonObject.isNull("weibo")){ this.weibo = jsonObject.getString("weibo"); }
	     
	     if( ! jsonObject.isNull("activityNum")){ this.activityNum = jsonObject.getInt("activityNum"); }
	     if( ! jsonObject.isNull("groupNum")){ this.groupNum = jsonObject.getInt("groupNum"); }
	     if( ! jsonObject.isNull("albumNum")){ this.albumNum = jsonObject.getInt("albumNum"); }
	     if( ! jsonObject.isNull("flowerNum")){ this.flowerNum = jsonObject.getInt("flowerNum"); }
	     if( ! jsonObject.isNull("followingNum")){ this.followingNum = jsonObject.getInt("followingNum"); }
	     if( ! jsonObject.isNull("photoNum")){ this.photoNum = jsonObject.getInt("photoNum"); }
	     if( ! jsonObject.isNull("songNum")){ this.songNum = jsonObject.getInt("songNum"); }
	     if( ! jsonObject.isNull("fanNum")){ this.fanNum = jsonObject.getInt("fanNum"); }
	     
	     if( !jsonObject.isNull("address")){
	    	 JSONObject address = jsonObject.getJSONObject("address");
	    	 if( ! address.isNull("province")){ this.province = address.getInt("province"); }
	    	 if( ! address.isNull("city")){ this.city = address.getInt("city"); }
	    	 if( ! address.isNull("area")){ this.area = address.getInt("area"); }
	     }
	}
}
