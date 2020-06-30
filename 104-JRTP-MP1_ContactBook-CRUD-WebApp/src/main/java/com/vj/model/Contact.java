package com.vj.model;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private Long contactNumber;
	private String contactEmail;
	private Date createdDate;
	private Date updatedDate;
	
}
