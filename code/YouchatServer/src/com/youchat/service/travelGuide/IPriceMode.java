package com.youchat.service.travelGuide;

import java.util.Date;
import java.util.List;

import com.youchat.entity.travelGuide.TravelGuide;

public interface IPriceMode {
	public void setTravelGuide(TravelGuide guide);
	public float getPriceAt(Date date);
	public List<Float> getPricesAt(Date month);
	public String getPriceName();
	public String getPriceFormula();
}
