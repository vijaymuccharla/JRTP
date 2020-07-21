package com.vj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vj.bindings.UnlockUser;
import com.vj.services.UserService;

@Controller
public class AccountUnlockController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/unlockUserAcc")
	public String unlockAccountLink(@RequestParam("email") String email,Model model) {
		UnlockUser user = new UnlockUser();
		model.addAttribute("email", email);
		model.addAttribute("unlockModel", user);
		return "unlockUser";
	}
	
	@PostMapping(value = "unlockWithNewPwd")
	public String newPwdUnlock(@ModelAttribute("unlockModel") UnlockUser unlock,Model model) {
		//user Service
		boolean isValid = userService.validateTempPwd(unlock);
		if(isValid)
			model.addAttribute("unlockSuccess", "Account Unlock Success, You may login now. :)");
		else
			model.addAttribute("unlockFailed", "Oops! Could not unlock your account :( \n Please try again using your UNLOCK Link!");
		
		return "unlockSuccess";
	}
}
