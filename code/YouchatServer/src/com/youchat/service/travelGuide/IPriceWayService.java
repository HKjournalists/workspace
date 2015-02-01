package com.youchat.service.travelGuide;

import java.util.List;

import com.youchat.dto.query.travelGuide.PriceWayQuery;
import com.youchat.entity.travelGuide.PriceWay;

public interface IPriceWayService {
    public boolean addPriceWay(PriceWay priceWay);
    public boolean updatePriceWay(PriceWay priceWay);
    public boolean deletePriceWay(PriceWay priceWay);
    public boolean deletePriceWays(List<PriceWay> priceWays);
    public List<PriceWay> queryPriceWay(PriceWayQuery query);
	public List<PriceWay> getAllPriceWays();
	public boolean deletePriceWayById(Integer valueOf);
}
