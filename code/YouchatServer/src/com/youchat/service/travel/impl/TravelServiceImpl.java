package com.youchat.service.travel.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youchat.entity.travelGuide.TravelGuide;
import com.youchat.service.travel.ITravelService;

/**
 * 攻略服务实现类
 * @author gyb
 * @date 2014-04-17
 *
 */
@Service
@Transactional
public class TravelServiceImpl implements ITravelService {

	@Override
	public boolean add(TravelGuide travel) {
		return false;
	}
	
}
