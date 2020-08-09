package com.vj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vj.model.SsnEnrollmentRequest;
import com.vj.services.SsaService;

@RestController
public class SsnEnrollmentRestController {

	@Autowired
	private SsaService service;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/enrollSsn",consumes = "application/json")
	public ResponseEntity<String> enrollReq(@RequestBody SsnEnrollmentRequest request) {
		Long ssn = service.ssnEnrollment(request);
		String body="Enrollmet Success, your SSN :: "+ssn;
		return new ResponseEntity<String>(body, HttpStatus.CREATED);
	}
}
