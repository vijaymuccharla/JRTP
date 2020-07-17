package com.vj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.model.Contact;
import com.vj.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService service;

	@GetMapping(value = { "/", "saveContact" })
	public String contactPage(Model model) {
		//load page with empty contact obj
		model.addAttribute("contact", new Contact());
		//return lvn
		return "contactpage";
	}

	@PostMapping(value = { "/saveContact" })
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, RedirectAttributes attributes) {
		//use service
		boolean saved = service.insertContact(c);
		if (saved == true) {
			attributes.addFlashAttribute("savedMsg", "Contact Saved");
			return "redirect:/saveContact";
		} else {
			attributes.addFlashAttribute("failedMsg", "Failed to Save");
			return "redirect:/saveContact";
		}
	}

	@GetMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(@RequestParam("email") String email) {
		boolean emailExists = service.getContactByEmail(email);
		if (emailExists)
			return "duplicate";
		else
			return "unique";
	}
}
