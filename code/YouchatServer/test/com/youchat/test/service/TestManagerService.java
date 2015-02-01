package com.youchat.test.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.youchat.dto.query.user.ManagerQuery;
import com.youchat.entity.user.Manager;
import com.youchat.service.user.IManagerService;
import com.youchat.test.base.BaseTest;
import com.youchat.utils.MD5Util;

public class TestManagerService extends BaseTest{
    @Autowired
    private IManagerService managerService;
    
    @Test
    public void testFindManager(){
        String  name    = "luc";
        Manager manager = managerService.findManagerByName(name);
        Assert.assertNotNull(manager);
        String password = MD5Util.getMD5("password");
        Assert.assertEquals(manager.getPassword(), password);
    }
    
    @Test
    public void testAddManager(){       
        String password = MD5Util.getMD5("password");
        boolean result =   false;
        for(int i = 0; i < 30; i++){
            Manager manager = new Manager();
            manager.setName("luc"+i);
            manager.setPassword(password);
            result = managerService.addManager(manager);
            Assert.assertEquals(result, true);
        }
    }
    @Test
    public void testQueryManager(){
        ManagerQuery    query    = new ManagerQuery();
        List<Manager>   managers = new ArrayList<Manager>(0);
        int             total    = 0;
        
        query.setUsePagination(true);
        query.setPageSize(15);
        query.setPageNo(1);
        query.setName("luc");
        
        managers = managerService.queryManagers(query);
        total    = managerService.queryManagersCount(query);
       
        System.out.println("query total = " + total);
        System.out.println("query size = " + managers.size());
        Assert.assertEquals(managers.size(), 15);
        for(Manager m : managers){
            System.out.println(m.getName()+" "+m.getPassword());
        }

        query.setPageNo(2);
        managers = managerService.queryManagers(query);
        total    = managerService.queryManagersCount(query);
        System.out.println("rowstart = " + query.getStartRow()+" endrow=" + query.getEndRow());
        System.out.println("query size = " + managers.size());
        Assert.assertEquals(managers.size(), 15);
        for(Manager m : managers){
            System.out.println(m.getName()+" "+m.getPassword());
        }
    }
}
