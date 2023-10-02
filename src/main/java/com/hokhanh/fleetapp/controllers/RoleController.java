package com.hokhanh.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hokhanh.fleetapp.models.Role;
import com.hokhanh.fleetapp.models.Role;
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.models.User;
import com.hokhanh.fleetapp.services.RoleService;
import com.hokhanh.fleetapp.services.RoleService;
import com.hokhanh.fleetapp.services.StateService;
import com.hokhanh.fleetapp.services.UserService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/roles")
	public String getAll(Model m) {
		List<Role> rolelist = this.roleService.getRoles();
		m.addAttribute("roleList", rolelist);
		
		return "Role";
	}
	
	@GetMapping("/security/user/edit/{id}")
	public String editUser(@PathVariable Integer id, Model model) {
		User user = this.userService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("userRoles", this.roleService.getUserRoles(user));
		model.addAttribute("userNotRoles", this.roleService.getUserNotRoles(user));
		return "userEdit";
	}
	
	@PostMapping("/roles/addNew")
	public String addNew(Role client) {
		this.roleService.addNew(client);
		return "redirect:/roles";
	}
	
	@GetMapping("/roles/getById")
	@ResponseBody
	public Role getRoleById(Integer id) {
		return this.roleService.getRoleById(id);	
	}
	
	@RequestMapping(value = "/roles/update", method = {RequestMethod.GET,RequestMethod.PUT})
	public String update(Role client) {
		this.roleService.updateRole(client);
		return "redirect:/roles";
	}
	
	@RequestMapping(value = "/roles/delete", method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(Integer id) {
		this.roleService.deleteRoleById(id);
		return "redirect:/roles";
	}
	
	@GetMapping("/security/role/assign/{userid}/{roleid}")
	public String assignRole(@PathVariable Integer userid, @PathVariable Integer roleid ) {
		this.roleService.assignUserRole(userid, roleid);
		return "redirect:/security/user/edit/"+userid;
	}
	
	@GetMapping("/security/role/unassign/{userid}/{roleid}")
	public String unassignRole(@PathVariable Integer userid, @PathVariable Integer roleid ) {
		this.roleService.unassignUserRole(userid, roleid);
		return "redirect:/security/user/edit/"+userid;
	}
}
