package com.vj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SSN_STT_TBL")
public class SsnStateEntity {
	
	@Id
	@Column(name = "SSN")
	private Long ssn;
	@Column(name = "STATE")
	private String state;
}
