package com.vj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entities.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {

	public List<StateEntity> findAllByCountryId(Integer countryId);
}
