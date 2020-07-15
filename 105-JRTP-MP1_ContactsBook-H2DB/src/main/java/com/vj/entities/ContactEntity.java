package com.vj.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACTS_TBL")
public class ContactEntity {

	@Id
	@SequenceGenerator(name = "ctct_seq", sequenceName = "CTCT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ctct_seq", strategy=GenerationType.SEQUENCE)
	@Column(name = "CTCT_ID")
	private Integer contactId;		//PK / not-null
	
	@Column(name = "CTCT_NM")
	private String contactName;		//can be null
	
	@Column(name = "CTCT_NMBR")
	private String contactNumber;	//made number as not-null in DB
	
	@Column(name = "CTCT_EML")
	private String contactEmail;	//made email as not-null in DB
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CRTD_ON", updatable = false)
	private Date createdDate;		//date of record insertion
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDTD_ON", insertable = false)		//date of modifying record
	private Date updatedDate;
}
