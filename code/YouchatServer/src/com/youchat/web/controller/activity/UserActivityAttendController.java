package com.youchat.web.controller.activity;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youchat.common.Constants;
import com.youchat.dto.biz.Result;
import com.youchat.dto.query.activity.UserActivityAttendQuery;
import com.youchat.entity.activity.UserActivityAttend;
import com.youchat.entity.user.User;
import com.youchat.service.activity.IUserActivityAttendService;

/**
 * 活动控制层
 * @author yangzuo
 * @date 2014-4-19
 *
 */
@Controller
public class UserActivityAttendController {
	
	@Autowired
	private IUserActivityAttendService service;
	
	/**
	 * 参与活动
	 * @param session
	 * @param activityId
	 * @return
	 */
	@RequestMapping("/activity/attendActivity.do")
	@ResponseBody
	public String attendActivity(HttpSession session, String activityId) {
		Result result = new Result();
		
		User user = (User) session.getAttribute(Constants.USER_INFO);
		if (user == null) {
			result.setSuccess(false);
			result.setMsg("用户未登录");
			return result.toJsonString();
		}
		
		UserActivityAttend entity = new UserActivityAttend();
		entity.setUserId(user.getId());
		entity.setActivityId(Integer.parseInt(activityId));
		
		boolean flg = service.createActivity(entity);
		result.setSuccess(flg);
		result.setMsg(flg ? "参加活动成功" : "参加活动失败");
		
		return result.toJsonString();
	}
	
	@RequestMapping("/activity/cancelAttendActivity.do")
	@ResponseBody
	public String cancelActivity(HttpSession session, String activityId) {
		Result result = new Result();
		
		User user = (User) session.getAttribute(Constants.USER_INFO);
		if (user == null) {
			result.setSuccess(false);
			result.setMsg("用户未登录");
			return result.toJsonString();
		}
		
		UserActivityAttendQuery query = new UserActivityAttendQuery();
		query.setUserId(user.getId());
		query.setActivityId(Integer.parseInt(activityId));
		
		UserActivityAttend entity = service.queryActivities(query).get(0);
		
		service.deleteActivity(entity);
		result.setSuccess(true);
		result.setMsg("取消活动成功");
		
		return result.toJsonString();
	}
}
