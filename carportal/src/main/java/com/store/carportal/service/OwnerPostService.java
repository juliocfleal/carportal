package com.store.carportal.service;

import org.springframework.stereotype.Service;

import com.store.carportal.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {

	void createOwnerPost(OwnerPostDTO ownerPostDTO);
}
