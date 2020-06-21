package com.vj.services;

import java.util.List;

import com.vj.model.Contact;

public interface IContactService {

	public String getNameById(Integer id);
	
	public List<String> getAllNames();
	
	public Contact getContactById(Integer id);
}
