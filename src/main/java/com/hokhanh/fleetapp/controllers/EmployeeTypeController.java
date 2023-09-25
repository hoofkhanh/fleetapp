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

import com.hokhanh.fleetapp.models.EmployeeType;
import com.hokhanh.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeetypes")
	public String getAll(Model m) {
		List<EmployeeType> EmployeeTypes =  this.employeeTypeService.getEmployeeTypes();
		m.addAttribute("employeeTypeList", EmployeeTypes);
		return "EmployeeType";
	}
	
	@GetMapping("employeetypes/getById")
	@ResponseBody
	public EmployeeType getById(Integer id) {
		return this.employeeTypeService.getById(id);
	}
	
	@PostMapping("/employeetypes/addNew")
	public String addNew(EmployeeType l) {
		this.employeeTypeService.addNew(l);
		return "redirect:/employeetypes";
	}
	
	@RequestMapping(value = "/employeetypes/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(EmployeeType l) {
		this.employeeTypeService.update(l);
		return "redirect:/employeetypes";
	}
	
	@RequestMapping(value = "/employeetypes/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.employeeTypeService.deleteById(id);
		return "redirect:/employeetypes";
	}
}
