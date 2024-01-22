package com.carportal.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carportal.api.client.CarPostStoreClient;
import com.carportal.api.dto.CarPostDTO;

@Service
public class CarPostServiceImpl implements CarPostStoreService{
	
	@Autowired
	private CarPostStoreClient carPostStoreClient;

	@Override
	public List<CarPostDTO> getCarForSales() {
		return carPostStoreClient.carForSaleClient();
	}

	@Override
	public void changeCarForSale(CarPostDTO carPost, String id) {
		carPostStoreClient.changeCarForSaleClient(carPost, id);
		
	}

	@Override
	public void removeCarForSale(String id) {
		carPostStoreClient.deleteCarForSaleClient(id);
		
	}

}
