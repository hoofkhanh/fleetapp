package com.hokhanh.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hokhanh.fleetapp.models.Country;
import com.hokhanh.fleetapp.services.CountryService;


@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countries")
	public String getCountries(Model m) {
		List<Country> countrylist = this.countryService.getCountries();
		m.addAttribute("countryList", countrylist);
		return "Country";
	}
	
	@PostMapping("/countries/addNew")
	public String addNew(Country country) {
		this.countryService.addNew(country);
		return "redirect:/countries";
	}
	
	@GetMapping("/countries/getById")
	@ResponseBody
	public Country getCountryById(Integer id) {
		return this.countryService.getCountryById(id);	
	}
	
	@RequestMapping(value = "/countries/update", method = {RequestMethod.GET,RequestMethod.PUT})
	public String update(Country country) {
		this.countryService.updateCountry(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value = "/countries/delete", method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(Integer id) {
		this.countryService.deleteCountryById(id);
		return "redirect:/countries";
	}
}
