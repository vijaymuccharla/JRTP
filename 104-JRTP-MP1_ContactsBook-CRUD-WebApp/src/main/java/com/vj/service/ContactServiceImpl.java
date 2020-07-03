package com.vj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.entities.ContactEntity;
import com.vj.model.Contact;
import com.vj.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	//inject Repository
	@Autowired
	private ContactRepository repo;

	/**
	 * 1. Empty entity object
	 * 
	 * 2. Convert Binding 'contact' object to Entity object 'entity'
	 * 
	 * 3. Pass Entity object with data to 
	 *    JpaRepository (ContactRepository) method to Save/Insert contact.
	 *    
	 * 4. Use ContactRepo and pass entity to insert / save.
	 * 
	 * 5. Return true if entity is saved or return false
	 */
	@Override
	public boolean saveContact(Contact contact) {
		
		ContactEntity entity=new ContactEntity();
		
		BeanUtils.copyProperties(contact, entity);
		
		ContactEntity savedEntity = repo.save(entity);
		
		return savedEntity.getContactId()!=null;
	}

	/**
	 * 
	 */
	@Override
	public List<Contact> getAllContacts() {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Contact getContactById(Integer cid) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public boolean updateContact(Contact c) {
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean deleteContact(Integer cid) {
		return false;
	}

}
