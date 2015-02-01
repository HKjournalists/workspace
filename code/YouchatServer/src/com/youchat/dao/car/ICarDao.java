package com.youchat.dao.car;


import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.car.Car;


/**
 * 车dao层
 * @author gyb
 * @date 2014-04-15
 *
 */
public interface ICarDao extends IBaseDao<Car>{
	public List<Car> selectAll();

	public List<Car> getCarsByTravelGuideId(Integer travelGuideId);
	
}
