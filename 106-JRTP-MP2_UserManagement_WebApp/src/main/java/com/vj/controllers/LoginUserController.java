package com.vj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.bindings.Login;
import com.vj.entities.UserEntity;
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
	 * validate credentials and give access only if Account is Unlocked
	 * @param login
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = "/userLogin")
	public String handleSubmitLogin(@ModelAttribute("loginModel") Login login, RedirectAttributes attributes) {
		//verify login details using UserService
		UserEntity validUser = userService.validateLoginCredentials(login);
		if (validUser != null) {
			boolean isUnlocked = userService.accountUnlockedOrNot(validUser);
			if (isUnlocked) {
				attributes.addFlashAttribute("welcomeName", login.getUserEmail());
				return "redirect:/dashboard";
			} else {
				attributes.addFlashAttribute("accountLocked", "You account is Locked, please contact admin.");
				return "redirect:/userLogin";
			}
		} else {
			attributes.addFlashAttribute("loginFailed",
					"Invalid Email/Password, please try again with valid credentials.");
			return "redirect:/userLogin";
		}
	}

	/**
	 PRG pattern to dashboard so that user dont have to login 
	 again when refreshing the dashboard page.
	 
	 * @return
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String redirectToDashboard() {
		return "userDashboard";
	}
}
