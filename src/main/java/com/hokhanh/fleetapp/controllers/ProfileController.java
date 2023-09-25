package com.hokhanh.fleetapp.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hokhanh.fleetapp.models.Employee;
import com.hokhanh.fleetapp.services.EmployeeService;

@Controller
public class ProfileController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/profile")
	public String getProfile(Model m, Principal principal) {
		
		String username = principal.getName();
		m.addAttribute("employee", this.employeeService.findByUsername(username));
		
		return "profile";
	}
	
	
}
