package com.vj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vj.model.Contact;
import com.vj.repository.ContactRepository;

@Controller
public class ContactDetailsController {

	@Autowired
	private ContactRepository repo;
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = {""})
	public String loadContactForm() {
		
		return "";
	}
	
	/**
	 * 
	 * @param c
	 * @param model
	 * @return
	 */
	@PostMapping(value = {""})
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, Model model) {
		
		return "";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = {""})
	public String handleViewAllContactsListLink(Model model) {
		
		return "";
	}
}
