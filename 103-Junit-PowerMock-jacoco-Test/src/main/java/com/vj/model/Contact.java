package com.vj.model;


public class Contact {

	private Integer contactId;
	private String contactName,contactAddrs;
	
	
	public Contact() {
		System.out.println("Contact.Contact()");
	}
	
	
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactAddrs() {
		return contactAddrs;
	}
	public void setContactAddrs(String contactAddrs) {
		this.contactAddrs = contactAddrs;
	}

	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactAddrs=" + contactAddrs
				+ "]";
	}
	
	
	
}
