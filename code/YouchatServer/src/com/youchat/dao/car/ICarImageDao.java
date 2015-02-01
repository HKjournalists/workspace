package com.youchat.dao.car;

import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.car.CarImage;


/**
 * 车图片dao层
 * @author gyb
 * @date 2014-04-15
 *
 */
public interface ICarImageDao extends IBaseDao<CarImage> {

	List<CarImage> getCarImagesByCarId(Integer carId);

	/**
	 * delete by guide id. 
	 * @param id
	 */
	void deleteByGuideId(Integer id);

}
