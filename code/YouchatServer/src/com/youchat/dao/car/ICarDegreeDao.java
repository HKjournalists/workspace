package com.youchat.dao.car;

import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.car.CarDegree;


/**
 * 车订单dao层
 * @author gyb
 * @date 2014-04-15
 *
 */
public interface ICarDegreeDao extends IBaseDao<CarDegree> {
	public List<CarDegree> selectAll();
}
