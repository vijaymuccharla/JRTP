package com.vj.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.entities.ContactEntity;
import com.vj.model.Contact;
import com.vj.service.ContactService;

@Controller
public class ViewAllContactsController {

	@Autowired
	private ContactService service;

	/**
		* Display all records
		* @param model
		* @return
		*/
	@GetMapping(value = { "/displayAllContacts" })
	public String handleViewAllContactsListLink(HttpServletRequest req, Model model) {

		Integer currPno = 1;
		Integer pageSize = 2;

		String pno = req.getParameter("pno");
		if (pno != null && !pno.equals("")) {
			currPno = Integer.parseInt(pno);
		}
		
		Page<ContactEntity> pageData = service.getAllContacts(pageSize, currPno - 1);
		List<ContactEntity> entities = pageData.getContent();
		int totalPages = pageData.getTotalPages();

		List<Contact> contactsList = entities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());

		
		
		model.addAttribute("contacts", contactsList);
		model.addAttribute("tp", totalPages);
		model.addAttribute("cpn", currPno);
		return "displayAllContacts";
	}
	

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
		//return As Contact page to use it as Editable page 
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
