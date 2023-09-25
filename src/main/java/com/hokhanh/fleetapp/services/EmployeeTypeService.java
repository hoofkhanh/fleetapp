package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.EmployeeType;
import com.hokhanh.fleetapp.repositories.EmployeeRepository;
import com.hokhanh.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeRepository;
	
	public List<EmployeeType> getEmployeeTypes() {
		return employeeRepository.findAll();
	}

	public void addNew(EmployeeType l) {
		try {
			this.employeeRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.employeeRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(EmployeeType l) {
		try {
			this.employeeRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EmployeeType getById(Integer id) {
		try {
			return this.employeeRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
