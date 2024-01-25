package com.store.carportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.carportal.dto.CarPostDTO;
import com.store.carportal.entity.CarPostEntity;
import com.store.carportal.repository.CarPostRepository;
import com.store.carportal.repository.OwnerPostRepository;

@Service
public class CarPostServiceImpl implements CarPostService {

	@Autowired
	private CarPostRepository carPostRepository;

	@Autowired
	private OwnerPostRepository ownerPostRepository;

	@Override
	public void newPostDetails(CarPostDTO carPostDTO) {
		CarPostEntity carPostEntity = mapCarDTOToEntity(carPostDTO);
		carPostRepository.save(carPostEntity);
	}


	@Override
	public List<CarPostDTO> getCarSales() {
		List<CarPostDTO> listCarSales = new ArrayList<>();
		carPostRepository.findAll().forEach(post -> {
			listCarSales.add(mapCarEntityToDTO(post));
		});
		return listCarSales;
	}

	@Override
	public void changeCarSale(CarPostDTO carPostDTO, Long postId) {
		carPostRepository.findById(postId).ifPresentOrElse(post -> {
			post.setDescription(carPostDTO.getDescription());
			post.setContact(carPostDTO.getContact());
			post.setPrice(carPostDTO.getPrice());
			post.setBrand(carPostDTO.getBrand());
			post.setEngineVersion(carPostDTO.getEngineVersion());
			post.setModel(carPostDTO.getModel());

			carPostRepository.save(post);
		}, () -> {
			throw new NoSuchElementException();
		});

	}

	@Override
	public void removeCarSale(Long postId) {
		carPostRepository.deleteById(postId);
	}

	private CarPostDTO mapCarEntityToDTO(CarPostEntity post) {
		CarPostDTO carPostDTO = new CarPostDTO();
		carPostDTO.setBrand(post.getBrand());
		carPostDTO.setCity(post.getCity());
		carPostDTO.setCreateDate(post.getCreateDate());
		carPostDTO.setDescription(post.getDescription());
		carPostDTO.setEngineVersion(post.getEngineVersion());
		carPostDTO.setModel(post.getModel());
		carPostDTO.setPrice(post.getPrice());
		carPostDTO.setOwnerName(post.getOwnerPost().getName());
		return carPostDTO;
	}
	
	private CarPostEntity mapCarDTOToEntity(CarPostDTO carPostDTO) {
		CarPostEntity carPostEntity = new CarPostEntity();
		ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(owner ->{
			carPostEntity.setOwnerPost(owner);
			carPostEntity.setContact(owner.getContactNumber());
		}, ()->{
			throw new RuntimeException();
		});
		carPostEntity.setModel(carPostDTO.getModel());
		carPostEntity.setBrand(carPostDTO.getBrand());
		carPostEntity.setPrice(carPostDTO.getPrice());
		carPostEntity.setCity(carPostDTO.getCity());
		carPostEntity.setDescription(carPostDTO.getDescription());
		carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
		carPostEntity.setCreateDate(String.valueOf(new Date()));
		
		return carPostEntity;
	}
}
