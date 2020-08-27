package com.vj.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vj.entities.ContactEntity;

@Repository	 //optional to mention
public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

	/**
	 * We use methods given by JpaRepository (I)
	 */
}
