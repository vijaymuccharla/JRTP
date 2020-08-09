package com.vj.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vj.entity.StatesDataEntity;

public interface StatesDataRepository extends JpaRepository<StatesDataEntity, Serializable>{

	@Query(value = "select stateName from StatesDataEntity")
	public List<String> findAllStates();
}
