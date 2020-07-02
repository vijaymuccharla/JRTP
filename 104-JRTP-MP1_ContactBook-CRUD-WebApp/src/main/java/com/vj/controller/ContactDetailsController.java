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
	 * This method takes GET mode request with 
	 * URL pattern "/" or "/loadForm" for ContactsBook homepage
	 * @return
	 */
	@GetMapping(value = { "/", "/loadForm" })
	public String loadContactForm(Model model) {
		//emty biding model obj to map with form data
		Contact c=new Contact();
		//add it to model attribute.
		model.addAttribute("contact", c);
		//return LVN of homepage 
		return "contactInfo";
	}

	/**
	 * 
	 * @param c
	 * @param model
	 * @return
	 */
	/*
	@PostMapping(value = {""})
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, Model model) {
	
	return "";
	}
	
	*//**
		* 
		* @param model
		* @return
		*//*
			@GetMapping(value = {""})
			public String handleViewAllContactsListLink(Model model) {
			
			return "";
			}*/
}
