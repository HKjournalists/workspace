package com.youchat.service.order;

import java.util.List;

import com.youchat.dto.biz.Result;
import com.youchat.entity.car.CarOrder;

public interface IStatusHandler {
	public Result handle();
	public void setOrder(CarOrder order);
	public String getStatusName();
	public List<Integer> getNextAvailableState();
}
