package com.youchat.dao.hotel;

import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.hotel.HotelInfo;

public interface IHotelInfo extends IBaseDao<HotelInfo> {
	/**
	 * 查询前几条列表
	 * @param object
	 * @return
	 */
	public List<HotelInfo> selectEntityListByTop(Object query);
	
}
