package com.carportal.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carportal.api.client.CarPostStoreClient;
import com.carportal.api.dto.OwnerPostDTO;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

	@Autowired
	private CarPostStoreClient carPostStoreClient;
	
	@Override
	public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
		carPostStoreClient.ownerPostClient(ownerPostDTO);
	}

}
