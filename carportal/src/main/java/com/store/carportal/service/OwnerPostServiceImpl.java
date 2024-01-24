package com.store.carportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.carportal.dto.OwnerPostDTO;
import com.store.carportal.entity.OwnerPostEntity;
import com.store.carportal.repository.OwnerPostRepository;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

	@Autowired
	private OwnerPostRepository ownerPostRepository;
	
	@Override
	public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
		
		OwnerPostEntity ownerPost = new OwnerPostEntity();
		ownerPost.setName(ownerPostDTO.getName());
		ownerPost.setType(ownerPostDTO.getType());
		ownerPost.setContactNumber(ownerPostDTO.getContactNumber());
		
		ownerPostRepository.save(ownerPost);
	}

}
