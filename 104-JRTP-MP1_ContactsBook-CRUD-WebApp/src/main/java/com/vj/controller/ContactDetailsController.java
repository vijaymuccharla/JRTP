package com.vj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vj.model.Contact;
import com.vj.service.ContactService;

@Controller
public class ContactDetailsController {

	//inject service
	@Autowired
	private ContactService service;

	/**
	 * This method takes GET mode request with 
	 * URL pattern "/" or "/loadForm" for ContactsBook homepage
	 * @return
	 */
	@GetMapping(value = { "/", "/loadForm" })
	public String loadContactForm(Model model) {
		System.out.println("ContactDetailsController.loadContactForm()");
		//add empty biding model object to map with form data
		model.addAttribute("contact", new Contact());
		//return LVN of home page 
		return "contactInfo";
	}

	/**
	 * This method takes POST request with binded form data of Contact.
	 * 
	 * @param c
	 * @param model
	 * @return
	 */

	@PostMapping(value = { "/loadForm" })
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, Model model) {

		//use service and pass contact with data for Insert operation
		boolean savedContact = service.saveContact(c);
		if (savedContact) {
			model.addAttribute("savedMsg", " Contact Save Successfully !! ");
		} else {
			model.addAttribute("failedMsg", " Failed to save contact ! ");
		}
		return "contactInfo";
	}

	/**
		* 
		* @param model
		* @return
		*//*
			@GetMapping(value = {""})
			public String handleViewAllContactsListLink(Model model) {
			
			return "";
			}*/
}
