package com.youchat.dao.hotel;

import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.hotel.HotelInfo;
import com.youchat.entity.hotel.HotelOrder;

public interface IHotelOrder extends IBaseDao<HotelOrder> {
	/**
	 * 更新订单状态
	 * @param object
	 * @return
	 */
	public Integer updateState(Object query);
}
