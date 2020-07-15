package com.vj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.model.Contact;
import com.vj.service.ContactService;

@Controller
public class ViewAllContactsController {

	@Autowired
	private ContactService service;

	/**
	 * 1. Takes the Contacts Id(pk) from the request param.
	 * 2. Using the ID calls service method to get the Contact Entity with that ID.
	 * @param cid
	 * @param model
	 * @return
	 */

	@GetMapping(value = { "/editContact" })
	public String editContactLink(@RequestParam("contactId") Integer cid, Model model) {
		//use repo
		Contact contact = service.getContactById(cid);
		//add binding obj to Model Attribute
		model.addAttribute("contact", contact);
		//return AssContact page to use it as Editable page 
		return "contactInfo";
	}

	/**
	 * 
	 * @param cid
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/deleteContact" })
	public String deleteContact(@RequestParam("contactId") Integer cid, RedirectAttributes attributes) {
		//use service and delete contact by ID
		boolean deleteContact = service.deleteContact(cid);
		if (deleteContact) {
			attributes.addFlashAttribute("deleteSuccess", " Contact deleted Successfully! ");
		} else {
			attributes.addFlashAttribute("deleteFailed", " Failed to delete Contact ! ");
		}
		return "redirect:/displayAllContacts";
	}
}
