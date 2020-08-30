package com.vj.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entity.SsnStateEntity;

public interface SsnStateRepository extends JpaRepository<SsnStateEntity, Serializable> {

	public SsnStateEntity findBySsnAndState(Long ssn, String state);
	
	public SsnStateEntity findBySsn(Long ssn);
}
