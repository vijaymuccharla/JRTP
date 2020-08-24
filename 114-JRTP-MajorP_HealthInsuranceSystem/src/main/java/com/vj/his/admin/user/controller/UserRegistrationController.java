package com.vj.his.admin.user.controller;

import static com.vj.his.admin.user.constants.AdminUserConstants.*;

import java.util.List;

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

import com.vj.his.admin.user.model.UserModel;
import com.vj.his.admin.user.service.UserService;

@Controller
public class UserRegistrationController {

	@Autowired
	UserService userService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/", "/createUser" })
	public String loadUserRegistrationForm(Model model) {
		UserModel userModel = new UserModel();
		model.addAttribute(USER_MODEL_NAME, userModel);
		return USER_REGISTRATION_LVN;
	}
	
	/**
	 * 
	 * @param userModel
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = { "/createUser" })
	public String handleSubmitButton(@ModelAttribute(USER_MODEL_NAME) UserModel userModel,
			RedirectAttributes attributes) {

		//use service and pass contact with data for Insert operation
		boolean userInserted = userService.insertNewUser(userModel);
		if (userModel.getUserId() == null) {
			if (userInserted)
				attributes.addFlashAttribute(USER_MODEL_INSERT_SUCCESS_ATTRIBUTE, USER_INSERTION_SUCESS);
			else
				attributes.addFlashAttribute(USER_MODEL_INSERT_FAILURE_ATTRIBUTE, USER_INSERTION_FAILED);
		} else {
			if (userInserted)
				attributes.addFlashAttribute(USER_MODEL_UPDATE_SUCCESS_ATTRIBUTE, USER_UPDATION_SUCESS);
			else
				attributes.addFlashAttribute(USER_MODEL_UPDATE_FAILURE_ATTRIBUTE, USER_UPDATION_FAILED);
		}
		//redirect the response to GET mode form to avoid Double posting problem
		return "redirect:/createUser";
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
		* Display all records
		* @param model
		* @return
		*/
	@GetMapping(value = { "/displayAllUsers" })
	public String handleViewAllUsersListLink(Model model) {
		//use service to call repo for getting all Users list
		List<UserModel> allUsers = userService.getAllUsers();
		//add all Contacts to Model Attribute
		model.addAttribute("users", allUsers);
		//return LVN of View All Contacts Page
		return "DisplayAllUsers";
	}

}
