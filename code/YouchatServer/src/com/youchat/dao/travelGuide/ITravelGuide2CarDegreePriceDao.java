package com.youchat.dao.travelGuide;

import java.util.List;

import com.youchat.dao.base.IBaseDao;
import com.youchat.dto.query.travelGuide.TravelGuide2CarDegreePriceQuery;
import com.youchat.entity.travelGuide.TravelGuide2CarDegreePrice;

/**
 * 价格表dao层
 * @author gyb
 * @date 2014-04-15
 *
 */
public interface ITravelGuide2CarDegreePriceDao extends IBaseDao<TravelGuide2CarDegreePrice> {

	TravelGuide2CarDegreePrice selectEntity(
			TravelGuide2CarDegreePriceQuery query);
	public List<TravelGuide2CarDegreePrice> selectByTravelGuideId(Integer travelGuideId);
	
	public List<TravelGuide2CarDegreePrice> selectAll();
	
	public Integer insertBatch(List<TravelGuide2CarDegreePrice> carDegrees);
	
	/**
	 * delete by guideId.
	 * @param guideId
	 * @return
	 */
	void deleteByGuideId(Integer guideId);
}
