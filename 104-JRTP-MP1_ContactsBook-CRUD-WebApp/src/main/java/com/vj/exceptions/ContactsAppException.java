package com.vj.exceptions;

public class ContactsAppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactsAppException() {
	}

	public ContactsAppException(String msg) {
		super(msg);
	}

}
