package com.vj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	 * 1. This method takes POST request with binded form data of Contact.
	 * 2. RedirectFlashAttributes will help us to access the model data 
	 * in redirected method as well.
	 * @param c
	 * @param model
	 * @return
	 */

	@PostMapping(value = { "/loadForm" })
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, RedirectAttributes attributes) {

		//use service and pass contact with data for Insert operation
		boolean savedContact = service.saveContact(c);
		if (c.getContactId() == null) {
			if (savedContact)
				attributes.addFlashAttribute("savedMsg", " Contact Saved Successfully !! ");
			else
				attributes.addFlashAttribute("failedMsg", " Failed to save contact ! ");
		} else {
			if (savedContact)
				attributes.addFlashAttribute("updateMsg", " Contact Updated Successfully !! ");
			else
				attributes.addFlashAttribute("updateFailMsg", " Failed to Update contact ! ");
		}
		//redirect the response to GET mode form to avoid Double posting problem
		return "redirect:/loadForm";
	}

}
