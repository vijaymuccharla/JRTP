package com.vj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STATES_DATA")
public class StatesDataEntity {

	@Id
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "STATE_NAME")
	private String stateName;
}
