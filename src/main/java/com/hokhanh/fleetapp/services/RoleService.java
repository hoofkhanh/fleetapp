package com.hokhanh.fleetapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Role;
import com.hokhanh.fleetapp.models.User;
import com.hokhanh.fleetapp.repositories.RoleRepository;
import com.hokhanh.fleetapp.repositories.UserRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Role> getRoles(){
		return this.roleRepository.findAll();
	}

	public void addNew(Role role) {
		try {
			this.roleRepository.save(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Role getRoleById(Integer id) {
		return this.roleRepository.findById(id).orElse(null);
	}

	public void updateRole(Role role) {
		try {
			this.roleRepository.save(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteRoleById(Integer id) {
		try {
			this.roleRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Role> getUserRoles(User user){
		return user.getRoles();
	}
	
	public List<Role> getUserNotRoles(User user){
		return this.roleRepository.getUserNotRoles(user.getId());
	}
	
	public void assignUserRole(Integer userId, Integer roleId) {
		User user = this.userRepository.findById(userId).orElse(null);
		List<Role> roles = user.getRoles();
		roles.add(this.roleRepository.findById(roleId).orElse(null));
		user.setRoles(roles);	
		this.userRepository.save(user);
	}
	
	public void unassignUserRole(Integer userId, Integer roleId) {
		User user = this.userRepository.findById(userId).orElse(null);
		List<Role> roles = user.getRoles();
		roles.removeIf(x -> x.getId() == roleId);
		System.out.println(roles);
		this.userRepository.save(user);
	}
}
