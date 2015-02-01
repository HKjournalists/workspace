package com.youchat.service.travelGuide.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youchat.dao.travelGuide.IPriceWayDao;
import com.youchat.dto.query.travelGuide.PriceWayQuery;
import com.youchat.entity.travelGuide.PriceWay;
import com.youchat.service.travelGuide.IPriceWayService;

@Service
@Transactional
public class PriceWayServiceImpl implements IPriceWayService {

	@Autowired
	private IPriceWayDao priceWayDao;

	@Override
	public boolean addPriceWay(PriceWay priceWay) {
		int code = priceWayDao.insert(priceWay);
		return code > 0;
	}

	@Override
	public boolean updatePriceWay(PriceWay priceWay) {
		// TODO Auto-generated method stub
		int code = priceWayDao.update(priceWay);
		return code > 0;
	}

	@Override
	public boolean deletePriceWay(PriceWay priceWay) {
		// TODO Auto-generated method stub
		priceWayDao.delete(priceWay);
		return true;
	}

	@Override
	public boolean deletePriceWays(List<PriceWay> priceWays) {
		// TODO Auto-generated method stub
		for(PriceWay p : priceWays)
			priceWayDao.delete(p);
		return true;
	}

	@Override
	public List<PriceWay> queryPriceWay(PriceWayQuery query) {
		// TODO Auto-generated method stub
		List<PriceWay> priceWays = priceWayDao.selectEntityList(query);
		return priceWays;
	}

	@Override
	public List<PriceWay> getAllPriceWays() {
		// TODO Auto-generated method stub
		List<PriceWay> priceWays = priceWayDao.selectAll(); 
		return priceWays==null?new ArrayList<PriceWay>():priceWays;
	}

	@Override
	public boolean deletePriceWayById(Integer id) {
		// TODO Auto-generated method stub
		PriceWay pw = new PriceWay();
		pw.setId(id);
		return deletePriceWay(pw);
	}

}
