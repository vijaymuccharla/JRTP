package com.vj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.bindings.ResetPassword;
import com.vj.services.UserService;

@Controller
public class ResetPasswordController {

	@Autowired
	private UserService service;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/resetPassword")
	public String resetPasswordLink(Model model) {
		model.addAttribute("PwdModel", new ResetPassword());
		return "ResetPassword";
	}

	/**
	 * Send password to given email account, to reset it.
	 * @param reset
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = "/resetPassword")
	public String passwordRecovery(@ModelAttribute("PwdModel") ResetPassword reset, Model model) {
		boolean userFound = service.getUserByEmail(reset.getRegisteredEmail());
		if (userFound) {
			service.sendPasswordTo(reset.getRegisteredEmail());
			model.addAttribute("PwdSent", "Password Sent to " + reset.getRegisteredEmail() + ", Please reset it.");
			return "PwdSent";
		} else {
			model.addAttribute("PwdNotSent", "No user found with that Email.");
			return "PwdSent";
		}
	}
}
