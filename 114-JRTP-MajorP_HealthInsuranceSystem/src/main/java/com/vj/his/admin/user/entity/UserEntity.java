package com.vj.his.admin.user.entity;

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
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "HIS_USER_DATA_TBL")
public class UserEntity {

	@Id
	@SequenceGenerator(name = "userSeq",sequenceName ="USER_SEQ",initialValue = 111,allocationSize = 1 )
	@GeneratedValue(generator = "userSeq", strategy =GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "USER_EMAIL")
	private String userEmail;
	
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	@Column(name = "USER_GENDER")
	private String userGender;
	
	@Column(name = "USER_ROLE")
	private String userRole;
	
	@Column(name = "ACTIVE_STATUS")
	private String activeStatus;
	
	@Column(name = "DELETE_SW")
	private String deleteSwitch;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_ON", insertable = false)
	private Date updatedDate;
	
}
