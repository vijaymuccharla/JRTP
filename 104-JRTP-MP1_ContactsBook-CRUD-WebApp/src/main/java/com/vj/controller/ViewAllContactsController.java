package com.vj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vj.repository.ContactRepository;

@Controller
public class ViewAllContactsController {

	@Autowired
	private ContactRepository repo;

	/**
	 * 
	 * @param cid
	 * @param model
	 * @return
	 */

	/*@GetMapping(value = { "/editContact" })
	public String editContactLink(Integer cid, Model model) {
	
		return "";
	}*/

	/**
		* 
		* @param contact
		* @param model
		* @return
		*/
	/*
	
	@GetMapping(value = {""})
	public String updateContact(Contact contact,Model model) {
	
	return "";
	}
	*//**
		* 
		* @param cid
		* @param model
		* @return
		*//*
			@GetMapping(value = {""})
			public String deleteContact(Integer cid,Model model) {
			
			return "";
			}*/
}
