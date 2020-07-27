package com.vj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.bindings.ResetPassword;

@Controller
public class ResetPasswordController {

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
	 * 
	 * @param reset
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = "/resetPassword")
	public String passwordRecovery(@ModelAttribute("PwdModel") ResetPassword reset, RedirectAttributes attributes) {

		return "";
	}
}
