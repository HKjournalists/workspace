package com.youchat.dao.user;

import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.user.Manager;

public interface IManagerDao extends IBaseDao<Manager>{
    /**
     * 
     * <b>Summary: </b>
     *     selectManagerByName(通过用户名称查找用户)
     * @param name
     * @return
     */
    public List<Manager> selectManagerByName(String name);
}
