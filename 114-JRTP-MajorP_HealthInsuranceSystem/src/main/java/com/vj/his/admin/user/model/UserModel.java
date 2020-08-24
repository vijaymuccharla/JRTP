package com.vj.his.admin.user.model;

import lombok.Data;

@Data
public class UserModel {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userPassword;
	private String userGender;
	private String userRole;
	private String activeStatus;
	private String deleteSwitch;
	
}
