package com.vj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "SSN_MSTR")
@Data
public class SsnMasterEntity {

	@Id
	@GenericGenerator(name = "ssn_generator", strategy = "com.vj.generators.SsnGenerator")
	@GeneratedValue(generator = "ssn_generator")
	@Column(name = "SSN")
	private Long ssn;
	
	@Column(name = "FST_NME")
	private String firstName;
	
	@Column(name = "LST_NME")
	private String lastName;
	
	@Column(name = "DT_OF_BRTH")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "CREATED_ON", updatable = false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name = "UPDATED_ON", insertable = false)
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name = "GNDR")
	private String gender;
	
	@Column(name = "STATE_NME")
	private String stateName;
	
}
