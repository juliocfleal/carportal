package com.analytics.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.entity.BrandAnalyticsEntity;
import com.analytics.data.entity.CarModelAnalyticsEntity;
import com.analytics.data.entity.CarModelPriceEntity;
import com.analytics.data.repository.BrandAnalyticsRepository;
import com.analytics.data.repository.CarModelAnalyticsRepository;
import com.analytics.data.repository.CarModelPriceRepository;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService{

	@Autowired
	private BrandAnalyticsRepository brandAnalyticsRepository;
	
	@Autowired
	private CarModelAnalyticsRepository carModelAnalyticsRepository;
	
	@Autowired
	private CarModelPriceRepository carModelPriceRepository;
	
	@Override
	public void saveAnalytics(CarPostDTO carPostDTO) {
		saveBrandAnalytics(carPostDTO.getBrand());
		saveCarModelAnalytics(carPostDTO.getModel());
		saveCarModelPriceanalytics(carPostDTO.getModel(), carPostDTO.getPrice());
		
	}

	private void saveCarModelPriceanalytics(String model, Double price) {
		CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();
		
		carModelPriceEntity.setModel(model);
		carModelPriceEntity.setPrice(price);
		carModelPriceRepository.save(carModelPriceEntity);
		
	}

	private void saveCarModelAnalytics(String model) {
		
		CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity(); 
		
		carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item -> {
			item.setPosts(item.getPosts() + 1);
			carModelAnalyticsRepository.save(item);
		}, () ->{
			carModelAnalyticsEntity.setModel(model);
			carModelAnalyticsEntity.setPosts(1L);
			carModelAnalyticsRepository.save(carModelAnalyticsEntity);
		});
		
	}

	private void saveBrandAnalytics(String brand) {
		
		BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();
		
		brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
			item.setPosts(item.getPosts() + 1);
			brandAnalyticsRepository.save(item);
		}, () ->{
			brandAnalyticsEntity.setBrand(brand);
			brandAnalyticsEntity.setPosts(1L);
			brandAnalyticsRepository.save(brandAnalyticsEntity);	
		});
		
	}

}
