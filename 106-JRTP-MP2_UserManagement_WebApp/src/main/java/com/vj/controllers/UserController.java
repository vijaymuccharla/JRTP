package com.vj.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.bidings.User;
import com.vj.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/", "/addUser" })
	public String loadRegisterForm(Model model) {
		//empty user binding obj
		User user = new User();
		//add empty obj to ModelAttribute
		model.addAttribute("userModel", user);
		//empty LinkedHashMap <key,value> obj
		Map<Integer, String> countriesMap = new LinkedHashMap<Integer, String>();
		//use Service and get all Countries
		countriesMap = userService.getAllCountries();
		//add map to modelAttribute (key,value)
		model.addAttribute("countriesMap", countriesMap);
		//return LVN
		return "userregistration";
	}

	@GetMapping(value = { "/validateEmail" })
	@ResponseBody
	public String validateEmail(@RequestParam("email") String email) {
		boolean emailExists = userService.getUserByEmail(email);
		if (emailExists)
			return "duplicate";
		else
			return "unique";
	}

	@GetMapping(value = { "/getAllStates" })
	@ResponseBody
	public Map<Integer, String> getAllStatesByCountryId(@RequestParam("cntryId") Integer countryId) {
		//user UserService return all states
		return userService.getAllStatesByCountryId(countryId);
	}

	@GetMapping(value = { "/getAllCities" })
	@ResponseBody
	public Map<Integer, String> getAllCitiesByStateId(@RequestParam("sttId") Integer stateId) {
		//user UserService return all cities
		return userService.getAllCitiesByStateId(stateId);
	}

	@PostMapping(value = { "/addUser" })
	public String handleSaveUserButton(@ModelAttribute("userModel") User user, RedirectAttributes attributes) {
		boolean insertedUser = userService.insertNewUser(user);
		if (insertedUser) {
			attributes.addFlashAttribute("addedMsg",
					" Registration success, please check you email for the password to login.");
		} else {
			attributes.addFlashAttribute("failedMsg", " Registration Unsuccess, please try again.");
		}
		return "redirect:/addUser";
	}

}
