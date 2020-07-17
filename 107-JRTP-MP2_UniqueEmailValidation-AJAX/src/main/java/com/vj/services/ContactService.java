package com.vj.services;

import com.vj.model.Contact;

public interface ContactService {

	public boolean insertContact(Contact c);
	public boolean getContactByEmail(String email);
}
