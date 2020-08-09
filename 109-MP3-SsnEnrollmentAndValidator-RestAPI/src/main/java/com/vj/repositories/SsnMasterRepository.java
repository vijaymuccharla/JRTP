package com.vj.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entity.SsnMasterEntity;

public interface SsnMasterRepository extends JpaRepository<SsnMasterEntity, Serializable>{

	public SsnMasterEntity findBySsnAndStateName(Long ssn, String stateName);
}
