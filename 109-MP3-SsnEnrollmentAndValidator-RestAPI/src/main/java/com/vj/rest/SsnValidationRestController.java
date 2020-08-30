package com.vj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vj.services.SsaService;

@RestController
public class SsnValidationRestController {

	@Autowired
	private SsaService service;
	
	@GetMapping(value = "/validateSsn/{ssn}/{state}")
	public ResponseEntity<String> ssnIsEnrolledOrNot(@PathVariable("ssn") String ssn, @PathVariable("state") String state){
		String ssnEnrolled = service.ssnEnrolledOrNot(Long.parseLong(ssn), state);
		return new ResponseEntity<>(ssnEnrolled, HttpStatus.OK);
	}
	
	@GetMapping(value = "/validSsnStt/{ssn}/{state}")
	public ResponseEntity<String> ssnIsValidOrNot(@PathVariable("ssn") String ssn, @PathVariable("state") String state){
		String ssnEnrolled = service.ssnSttValidOrNot(Long.parseLong(ssn), state);
		return new ResponseEntity<>(ssnEnrolled, HttpStatus.OK);
	}
	
	@GetMapping(value = "/validSsn/{ssn}")
	public ResponseEntity<String> ssnFoundOrNot(@PathVariable("ssn") String ssn){
		String ssnFound = service.ssnFoundOrNot(Long.parseLong(ssn));
		return new ResponseEntity<>(ssnFound, HttpStatus.OK);
	}
	
	
}
