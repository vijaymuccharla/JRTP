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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class UserEntity {

	@Id
	@SequenceGenerator(name = "user_seq", sequenceName = "USER_ID_GEN", allocationSize = 1, initialValue = 100)
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "USER_PHONE")
	private String userPhone;

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_DOB")
	private Date userDob;

	@Column(name = "USER_GENDER")
	private String userGender;

	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	@Column(name = "STATE_ID")
	private Integer stateId;

	@Column(name = "CITY_ID")
	private Integer cityId;

	@Column(name = "ACCOUNT_STATUS")
	private String accountStatus;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_ON", insertable = false)
	private Date updatedDate;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

}
