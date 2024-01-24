package com.store.carportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.carportal.entity.CarPostEntity;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long>{

}
