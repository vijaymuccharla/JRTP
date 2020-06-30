package com.vj.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACTS_TBL")
public class ContactEntity {

	@Id
	@SequenceGenerator(name = "ctct_seq", sequenceName = "CTCT_ID_SEQ")
	@GeneratedValue(generator = "ctct_seq", strategy=GenerationType.SEQUENCE)
	@Column(name = "CTCT_ID")
	private Integer contactId;
	
	@Column(name = "CTCT_NM")
	private String contactName;
	
	@Column(name = "CTCT_NMBR")
	private String contactNumber;
	
	@Column(name = "CTCT_EML")
	private String contactEmail;
	
	@Column(name = "CRTD_ON")
	private Date createdDate;
	
	@Column(name = "UPDTD_ON")
	private Date updatedDate;
}
