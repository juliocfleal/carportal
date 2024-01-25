package com.carportal.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carportal.api.dto.OwnerPostDTO;
import com.carportal.api.service.OwnerPostService;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

	private final Logger LOG = (Logger) LoggerFactory.getLogger(OwnerPostController.class);

	@Autowired
	private OwnerPostService ownerPostService;
	
	@PostMapping
	public ResponseEntity createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
		LOG.info("Main REST Api produce Owner Post Information : {}", ownerPostDTO);
		ownerPostService.createOwnerCar(ownerPostDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
