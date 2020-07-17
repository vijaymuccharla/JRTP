package com.vj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entity.ContactEntity;

//@Repository		//optional
public interface ContactRepositroy extends JpaRepository<ContactEntity, Integer>{
	//select * from cntct_tbl where ctct_email="";
	public ContactEntity findByContactEmail(String email);
}
