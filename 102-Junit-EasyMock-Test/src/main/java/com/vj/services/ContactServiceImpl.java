package com.vj.services;

import com.vj.dao.IContactDao;

public class ContactServiceImpl implements IContactService {

	private IContactDao contactDao;
	
	//setter injection for DAO
	public void setDao(IContactDao dao) {
		this.contactDao = dao;
	}

	
	public String getNameById(Integer id) {
		String nameById = contactDao.findNameById(id);
		return nameById.toUpperCase();
	}

}
