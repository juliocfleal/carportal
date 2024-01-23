package com.carportal.api.service;

import org.springframework.stereotype.Service;

import com.carportal.api.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {

	void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
