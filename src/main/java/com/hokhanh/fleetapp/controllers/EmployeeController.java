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

import com.hokhanh.fleetapp.models.Country;
import com.hokhanh.fleetapp.models.Employee;
import com.hokhanh.fleetapp.models.EmployeeType;
import com.hokhanh.fleetapp.models.JobTitle;
import com.hokhanh.fleetapp.models.Employee;
import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.models.Vehicle;
import com.hokhanh.fleetapp.models.VehicleMake;
import com.hokhanh.fleetapp.models.VehicleModel;
import com.hokhanh.fleetapp.models.VehicleStatus;
import com.hokhanh.fleetapp.models.VehicleType;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.EmployeeService;
import com.hokhanh.fleetapp.services.EmployeeTypeService;
import com.hokhanh.fleetapp.services.JobTitleService;
import com.hokhanh.fleetapp.services.StateService;
import com.hokhanh.fleetapp.services.EmployeeService;
import com.hokhanh.fleetapp.services.VehicleTypeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@Autowired
	private JobTitleService jobTitleService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/employees")
	public String getEmployees(Model m) {
		List<Employee> employees = employeeService.getEmployees();
		List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
		List<JobTitle> jobTitles = jobTitleService.getJobTitles();
		List<Country> countries = countryService.getCountries();
		List< State> states = stateService.getStates();
		m.addAttribute("employeeList", employees);
		m.addAttribute("employeeTypeList", employeeTypes);
		m.addAttribute("jobTitleList", jobTitles);
		m.addAttribute("countryList", countries);
		m.addAttribute("stateList", states);
		return "Employee";
	}	
	
	@PostMapping("/employees/addNew")
	public String addNew(Employee employee) {
		this.employeeService.addNew(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/getById")
	@ResponseBody
	public Employee getEmployeeById(Integer id) {
		return this.employeeService.getEmployeeById(id);	
	}
	
	@RequestMapping(value = "/employees/update", method = {RequestMethod.GET,RequestMethod.PUT})
	public String update(Employee employee) {
		this.employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value = "/employees/delete", method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(Integer id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	@GetMapping(value = "/employees/assignUsername")
	public String assignUsername(Integer id) {
		this.employeeService.assignUsername(id);
		return "redirect:/employees";
	}

}
