package com.vj.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vj.model.SsnEnrollmentRequest;

public interface SsaService {

	public Long ssnEnrollment(SsnEnrollmentRequest request);
	public List<String> getAllStates();
	public String ssnEnrolledOrNot(Long ssn, String stateName);
	String ssnSttValidOrNot(Long ssn, String stateName);
	String ssnFoundOrNot(Long ssn);
}
