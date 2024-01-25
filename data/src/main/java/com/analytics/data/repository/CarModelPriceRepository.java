package com.analytics.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.analytics.data.entity.CarModelPriceEntity;

@Repository
public interface CarModelPriceRepository extends JpaRepository<CarModelPriceEntity, Long> {

	Optional<CarModelPriceEntity> findByModel(String model);
}
