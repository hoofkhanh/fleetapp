package com.hokhanh.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hokhanh.fleetapp.models.User;
import com.hokhanh.fleetapp.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getUsers(Model m) {
		List<User> userList = this.userService.getAll();
		m.addAttribute("userList", userList);
		return "User";
	}

	@PostMapping("/users/addNew")
	public RedirectView register(User user, RedirectAttributes redirectAttributes) {
		this.userService.save(user);
		System.out.println("1");
		RedirectView redirectView = new RedirectView("/login", true);
		redirectAttributes.addFlashAttribute("message", "You successfully registered! You can now login");
		return redirectView;
	}
}
