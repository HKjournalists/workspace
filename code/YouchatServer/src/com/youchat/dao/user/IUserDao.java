package com.youchat.dao.user;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.user.User;

public interface IUserDao extends IBaseDao<User> {
	public String getNameById(Integer id);
}
