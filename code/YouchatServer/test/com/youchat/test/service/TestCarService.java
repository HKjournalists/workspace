package com.youchat.test.service;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.youchat.dao.car.ICarDao;
import com.youchat.entity.car.Car;
import com.youchat.service.car.ICarService;
import com.youchat.test.base.BaseTest;

public class TestCarService extends BaseTest{
    
    @Autowired
    private ICarDao carDao;
    
    @Autowired
    private ICarService carService;
    
    @Test
    public void testAddCar(){
        Car car = new Car();
        car.setName("car2");
        boolean result = carService.addCar(car);
        Assert.assertEquals(result, true);
    }

    @Test
    public void testSelectByType(){
        String type = "type";
    }
    
    public static void main(String args[]){
    	int month = 2;
    	int day =1;
    	int year =2014;
    	Calendar ca = Calendar.getInstance();
    	month = ca.get(Calendar.MONTH) + 1;
    	year = ca.get(Calendar.YEAR);
    	day = ca.getActualMaximum(Calendar.DATE);
    	
    	System.out.println(String.format("%d%02d%02d",year, month, day));
    	return ;
    }
}
