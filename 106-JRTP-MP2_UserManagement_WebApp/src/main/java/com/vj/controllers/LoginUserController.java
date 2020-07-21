package com.vj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.bindings.Login;
import com.vj.services.UserService;

@Controller
public class LoginUserController {

	@Autowired
	UserService userService;

	/**
	 * login page
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/userLogin")
	public String userLoginLink(Model model) {
		Login login = new Login();
		model.addAttribute("loginModel", login);
		return "loginPage";
	}

	/**
	 * validate credentials and give access
	 * @param login
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = "/userLogin")
	public String handleSubmitLogin(@ModelAttribute("loginModel") Login login, RedirectAttributes attributes) {
		//verify login details using UserService
		boolean authentication = userService.loginCredentialsValid(login);
		if (authentication) {
			attributes.addFlashAttribute("welcomeName", login.getUserEmail() + ",");
			return "userDashboard";
		} else {
			attributes.addFlashAttribute("loginFailed",
					"Invalid Email/Password, please try again with valid credentials.");
			return "redirect:/userLogin";
		}
		
	
	}
}
