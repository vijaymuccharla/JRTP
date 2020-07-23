package com.vj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vj.bindings.ResetPassword;

@Controller
public class ResetPasswordController {

	@GetMapping(value = "/resetPassword")
	public String resetPasswordLink(Model model) {
		model.addAttribute("resetAccount", new ResetPassword());
		return "resetPassword";
	}
	
}
