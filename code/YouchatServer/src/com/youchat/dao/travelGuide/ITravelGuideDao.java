package com.youchat.dao.travelGuide;

import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.entity.travelGuide.TravelGuide;

public interface ITravelGuideDao extends IBaseDao<TravelGuide> {

	public List<TravelGuide> getSimpleAllGuide();
}
