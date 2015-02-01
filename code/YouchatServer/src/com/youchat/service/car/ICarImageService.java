package com.youchat.service.car;

import java.util.List;

import com.youchat.dto.query.car.CarImageQuery;
import com.youchat.entity.car.CarImage;

public interface ICarImageService {
    public boolean addCarImage(CarImage carImage);
    public boolean updateCarImage(CarImage carImage);
    public boolean deleteCarImage(CarImage carImage);
    public boolean deleteCarImages(List<CarImage> carImages);
    public List<CarImage> queryCarImage(CarImageQuery query);
	public List<CarImage> getAllCarImages();
	public boolean deleteCarImageById(Integer valueOf);
	public List<CarImage> getCarImages(int carId);
}
