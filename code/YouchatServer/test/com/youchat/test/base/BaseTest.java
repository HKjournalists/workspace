/**
 * <b>项目名：</b>AgrLeaders<br/>  
 * <b>包名：</b>com.argleader.test.base<br/>  
 * <b>文件名：</b>BaseTest.java<br/> 
 * <b>日期：</b>2013-6-26 上午10:14:04<br/>  
 * <b>Copyright (c)</b> <br/>    
 */
package com.youchat.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * <b>类描述：</b><br/>  
 * <b>@author </b>shixiangjian<br/>  
 * <b>修改时间：</b>2013-6-26 上午10:14:04<br/> 
 * <b>修改备注：</b><br/> 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:app*.xml"})
public class BaseTest {

}
