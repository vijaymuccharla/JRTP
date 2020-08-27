package com.vj.service;

import org.springframework.data.domain.Page;

import com.vj.entities.ContactEntity;
import com.vj.model.Contact;

public interface ContactService {

	/**
	 * Takes Binded Contact Obj Data 
	 * and inserts record then returns Boolean
	 * @param contact
	 * @return
	 */
	public boolean saveContact(Contact contact);

	/**
	 * Returns All available Contacts Records 
	 * as List of Binding Contact Objs
	 * @return
	 */
	Page<ContactEntity> getAllContacts(int pageNo, int pageSize);

	/**
	 * Takes ContactId from Request and Returns 
	 * the respective Contact Record as Binding Contact Obj
	 * @param cid
	 * @return
	 */
	public Contact getContactById(Integer cid);

	/**
	 * Takes Contact ID from Request data, 
	 * and returns Boolean based on 
	 * the given record is deleted or not   
	 * @param cid
	 * @return
	 */
	public boolean deleteContact(Integer cid);

}
