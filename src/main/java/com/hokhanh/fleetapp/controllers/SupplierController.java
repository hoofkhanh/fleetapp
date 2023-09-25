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
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.models.Supplier;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.StateService;
import com.hokhanh.fleetapp.services.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/suppliers")
	public String getAll(Model m) {
		List<Supplier> suppliers =  this.supplierService.getSuppliers();
		List<Country> countries =  this.countryService.getCountries();
		List<State> states =  this.stateService.getStates();
		m.addAttribute("supplierList", suppliers);
		m.addAttribute("countryList", countries);
		m.addAttribute("stateList", states);
		return "Supplier";
	}
	
	@GetMapping("suppliers/getById")
	@ResponseBody
	public Supplier getById(Integer id) {
		return this.supplierService.getSupplierById(id);
	}
	
	@PostMapping("/suppliers/addNew")
	public String addNew(Supplier l) {
		this.supplierService.addNew(l);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value = "/suppliers/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Supplier l) {
		this.supplierService.updateSupplier(l);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value = "/suppliers/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.supplierService.deleteSupplierById(id);
		return "redirect:/suppliers";
	}
}
