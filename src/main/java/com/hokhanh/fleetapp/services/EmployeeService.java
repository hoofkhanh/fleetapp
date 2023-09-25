package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Country;
import com.hokhanh.fleetapp.models.Employee;
import com.hokhanh.fleetapp.models.Employee;
import com.hokhanh.fleetapp.repositories.CountryRepository;
import com.hokhanh.fleetapp.repositories.EmployeeRepository;
import com.hokhanh.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeTypeRepository;
	
	public List<Employee> getEmployees(){
		return this.employeeTypeRepository.findAll();
	}
	
	public void addNew(Employee employee) {
		try {
			this.employeeTypeRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Employee getEmployeeById(Integer id) {
		return this.employeeTypeRepository.findById(id).orElse(null);
	}

	public void updateEmployee(Employee employee) {
		try {
			this.employeeTypeRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployeeById(Integer id) {
		try {
			this.employeeTypeRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
