package com.vj.services;

import java.util.List;

import com.vj.dao.IContactDao;
import com.vj.exceptions.NoDataFoundException;
import com.vj.model.Contact;

public class ContactServiceImpl implements IContactService {

	private IContactDao contactDao;

	public ContactServiceImpl() {
		System.out.println("ContactServiceImpl.ContactServiceImpl()");
	}
	
	//setter injection for DAO
	public void setDao(IContactDao dao) {
		System.out.println("ContactServiceImpl.setDao()");
		this.contactDao = dao;
	}


	public String getNameById(Integer id) {
		System.out.println("ContactServiceImpl.getNameById()");
		return contactDao.findNameById(id).toUpperCase();
	}


	public List<String> getAllNames() {
		System.out.println("ContactServiceImpl.getAllNames()");
		List<String> names = contactDao.findAllNames();
		if(names!=null) {
			return names;
		}
		return null;
	}


	public Contact getContactById(Integer id) {
		System.out.println("ContactServiceImpl.getContactById()");
		Contact contact=contactDao.findContactByContactId(id);
		if(contact==null) {
			throw new NoDataFoundException("No record Found");
		}
		System.out.println(contact);
		return contact;
	}

}
