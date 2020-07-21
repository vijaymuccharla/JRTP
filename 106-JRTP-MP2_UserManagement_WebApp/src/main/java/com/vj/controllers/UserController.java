package com.vj.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.bindings.User;
import com.vj.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param model
	 * @return
	 */
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

	/**
	 * 
	 * @param user
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = { "/addUser" })
	public String handleSaveUserButton(@ModelAttribute("userModel") User user, Model model) {
		boolean insertedUser = userService.insertNewUser(user);
		if (insertedUser) {
			model.addAttribute("addedMsg", " Registration success, please check your email to 'Unlock your Account'.");
		} else {
			model.addAttribute("failedMsg", " Registration Unsuccess, please try again.");
		}
		return "regsuccess";
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = { "/validateEmail" }, method = RequestMethod.GET)
	@ResponseBody
	public String validateEmail(@RequestParam("email") String email) {
		boolean emailExists = userService.getUserByEmail(email);
		if (emailExists)
			return "duplicate";
		else
			return "unique";
	}

	/**
	 * 
	 * @param countryId
	 * @return
	 */
	@RequestMapping(value = { "/getAllStates" }, method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> getAllStatesByCountryId(@RequestParam("cntryId") Integer countryId) {
		//use UserService return all states
		return userService.getAllStatesByCountryId(countryId);
	}

	/**
	 * 
	 * @param stateId
	 * @return
	 */
	@RequestMapping(value = { "/getAllCities" }, method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> getAllCitiesByStateId(@RequestParam("sttId") Integer stateId) {
		//use UserService return all cities
		return userService.getAllCitiesByStateId(stateId);
	}

}
