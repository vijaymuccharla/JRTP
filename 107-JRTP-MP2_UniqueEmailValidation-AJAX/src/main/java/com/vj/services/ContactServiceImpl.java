package com.vj.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.entity.ContactEntity;
import com.vj.model.Contact;
import com.vj.repository.ContactRepositroy;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepositroy repo;

	@Override
	public boolean insertContact(Contact c) {
		//convert Contact to ContactEntity
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		//save-insert entity using repo
		ContactEntity savedContact = repo.save(entity);
		if (savedContact.getContactId() != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean getContactByEmail(String email) {

		ContactEntity contactEntity = repo.findByContactEmail(email);
		if (contactEntity!= null)
			return true;
		else
			return false;
	}

}
