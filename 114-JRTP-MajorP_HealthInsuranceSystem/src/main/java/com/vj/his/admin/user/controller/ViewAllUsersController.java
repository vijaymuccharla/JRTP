package com.vj.his.admin.user.controller;

import static com.vj.his.admin.user.constants.AdminUserConstants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.his.admin.user.model.UserModel;
import com.vj.his.admin.user.service.UserService;

@Controller
public class ViewAllUsersController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/editUser" })
	public String editContactLink(@RequestParam("userId") Integer userId, Model model) {
		//use repo
		UserModel userModel= userService.getUserById(userId);
		//add binding obj to Model Attribute
		model.addAttribute("UserModel", userModel);
		//return UserModel page to use it as Editable page 
		return "HisUserReg";
	}

	/**
	 * 
	 * @param cid
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/deleteUser" })
	public String deleteContact(@RequestParam("userId") Integer userId, RedirectAttributes attributes) {
		//use service and delete contact by ID
		boolean deletedUser = userService.deleteUser(userId);
		if (deletedUser) {
			attributes.addFlashAttribute( USER_MODEL_DELETE_SUCCESS_ATTRIBUTE, USER_DELETION_SUCESS);
		} else {
			attributes.addFlashAttribute(USER_MODEL_DELETE_FAILURE_ATTRIBUTE, USER_DELETION_FAILED);
		}
		return "redirect:/displayAllUsers";
	}
}
