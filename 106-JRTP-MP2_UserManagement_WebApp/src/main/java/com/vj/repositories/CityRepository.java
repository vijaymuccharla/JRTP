package com.vj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entities.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

	public List<CityEntity> findAllByStateId(Integer statedId);
}
