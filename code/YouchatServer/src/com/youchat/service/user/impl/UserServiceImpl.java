package com.youchat.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youchat.dao.user.IUserDao;
import com.youchat.dto.query.user.UserQuery;
import com.youchat.entity.user.User;
import com.youchat.service.user.IUserService;
import com.youchat.utils.MD5Util;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	 @Autowired
	 private IUserDao userDao;

	@Override
	public boolean register(User user) {
		String md5pwd = MD5Util.getMD5(user.getPassword());
		user.setPassword(md5pwd);
		Integer result = userDao.insert(user);
		return result > 0;
	}

	@Override
	public boolean updateUser(User user) {
		Integer result = userDao.update(user);
		return result > 0;
	}

	@Override
	public List<User> queryUser(UserQuery query) {
		List<User> users = userDao.selectEntityList(query);
		return users == null ? new ArrayList<User>(0) : users;
	}

	@Override
	public int queryCount(UserQuery query) {
		Integer result = userDao.selectEntityCount(query);
		return result == null ? 0 : result;
	}
	
	@Override
	public User login(UserQuery query){
		String md5pwd = MD5Util.getMD5(query.getPassword());
		query.setPassword(md5pwd);	
		List<User> list = queryUser(query);
		return list.isEmpty() ? null : list.get(0) ;
	}

	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}
	
	
}
