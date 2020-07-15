package com.vj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.entities.ContactEntity;
import com.vj.exceptions.ContactsAppException;
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

		boolean isSaved = false;

		//create an empty entity
		ContactEntity entity = new ContactEntity();

		try {
			//copy binding obj to entity obj
			BeanUtils.copyProperties(contact, entity);
			/*
			 save the record, here Save Method is a Polymorphic method.
			It Inserts the record if there is no Contact ID given in entity.
			It updates the record if there is Contact ID is present within entity obj
			*/
			ContactEntity savedEntity = repo.save(entity);
			if (savedEntity.getContactId() != null) {
				isSaved = true;
			}
		} catch (Exception e) {
			throw new ContactsAppException();
		}
		return isSaved;
	}

	/**
	 * 1. Use ContactRepository and call findAll() method to get all Contacts List
	 * 2. Convert List of Entities to Binding objs
	 */
	@Override
	public List<Contact> getAllContacts() {

		//Get List of Contact Entities
		List<ContactEntity> entityList = repo.findAll();

		//legacy approach
		/*
		//empty List of Contact Binding objects 
		List<Contact> contacts=new ArrayList();
		
			entityList.forEach(entity->{
			
			//empty Binding object
			Contact c=new Contact();
			
			//copy Entity to Binding obj
			BeanUtils.copyProperties(entity, c);
			
			//add Binding obj with data to List of ContactBinding objects
			contacts.add(c);
		});
		
		//return list of Binding Contact Objects
		return contacts;
		
		*/

		//java 8 approach
		return entityList.stream().map(entity -> {
			//empty Binding object
			Contact c = new Contact();

			//copy Entity to Binding obj
			BeanUtils.copyProperties(entity, c);
			//return contact
			return c;
		}).collect(Collectors.toList());
	}

	/**
	 * use repo to get contact by id
	 */
	@Override
	public Contact getContactById(Integer cid) {

		Optional<ContactEntity> contactById = repo.findById(cid);

		if (contactById.isPresent()) {

			//convert ContactEntity to Contact
			Contact c = new Contact();
			//get entity
			ContactEntity entity = contactById.get();
			//copy entity to binding obj
			BeanUtils.copyProperties(entity, c);

			//return contact
			return c;
		}
		return null;

	}

	/**
	 * Delet contact by id
	 */
	@Override
	public boolean deleteContact(Integer cid) {
		if (cid != null) {
			//delete contact by id
			repo.deleteById(cid);
			return true;
		} else
			return false;
	}

}
