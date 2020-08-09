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
	public ResponseEntity<String> ssnIsEnrolled(@PathVariable("ssn") String ssn, @PathVariable("state") String state){
		String ssnEnrolled = service.ssnEnrolledOrNot(Long.parseLong(ssn), state);
		return new ResponseEntity<>(ssnEnrolled, HttpStatus.OK);
	}
}
