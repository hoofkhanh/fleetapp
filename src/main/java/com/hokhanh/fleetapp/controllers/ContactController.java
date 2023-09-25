package com.hokhanh.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hokhanh.fleetapp.models.Contact;
import com.hokhanh.fleetapp.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public String getCountries(Model m) {
		List<Contact> contactlist = this.contactService.getContacts();
		m.addAttribute("contactList", contactlist);
		return "Conntact";
	}
	
	@PostMapping("/contacts/addNew")
	public String addNew(Contact contact) {
		this.contactService.addNew(contact);
		return "redirect:/contacts";
	}
	
	@GetMapping("/contacts/getById")
	@ResponseBody
	public Contact getContactById(Integer id) {
		return this.contactService.getContactById(id);	
	}
	
	@RequestMapping(value = "/contacts/update", method = {RequestMethod.GET,RequestMethod.PUT})
	public String update(Contact contact) {
		this.contactService.updateContact(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value = "/contacts/delete", method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(Integer id) {
		this.contactService.deleteContactById(id);
		return "redirect:/contacts";
	}
}
