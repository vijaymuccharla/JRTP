package com.vj.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping(value = "user/{name}")
	public ResponseEntity<String> welcomeUser(@PathVariable("name") String username){
		String response="welcome "+username;
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
