package com.vj.dao;

import java.util.List;

import com.vj.model.Contact;

public interface IContactDao {

	public String findNameById(Integer id);
	
	public List<String> findAllNames();
	
	public Contact findContactByContactId(Integer id);
	
	
	
}
