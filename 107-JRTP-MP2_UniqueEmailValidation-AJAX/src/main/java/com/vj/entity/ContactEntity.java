package com.vj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CTCT_TBL")
public class ContactEntity {

	@Id
	@GeneratedValue
	@Column(name = "CONT_ID")
	private Integer contactId;
	@Column(name = "CONT_NAME")
	private String contactName;
	@Column(name = "CONT_EMAIL")
	private String contactEmail;
	@Column(name = "CONT_NUMBER")
	private Long contactNumber;
	
}
