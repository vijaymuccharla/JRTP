package com.vj.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
//@XmlRootElement for XML
public class SsnEnrollmentRequest {

	private String firstName;
	
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	private String gender;
	
	private String stateName;
	
}
