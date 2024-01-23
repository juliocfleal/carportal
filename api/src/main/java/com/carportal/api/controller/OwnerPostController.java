package com.carportal.api.controller;

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

	@Autowired
	private OwnerPostService ownerPostService;
	
	@PostMapping("")
	public ResponseEntity createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
		ownerPostService.createOwnerCar(ownerPostDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
