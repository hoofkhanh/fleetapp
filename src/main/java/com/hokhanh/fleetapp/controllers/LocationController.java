package com.hokhanh.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hokhanh.fleetapp.models.Country;
import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.LocationService;
import com.hokhanh.fleetapp.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/locations")
	public String getLocations(Model m) {
		List<Location> locations =  this.locationService.getLocations();
		List<State> states = this.stateService.getStates();
		List<Country> countries = this.countryService.getCountries();
		m.addAttribute("locationList", locations);
		m.addAttribute("stateList", states);
		m.addAttribute("countryList", countries);
		return "Location";
	}
	
	@GetMapping("locations/getById")
	@ResponseBody
	public Location getByLocationById(Integer id) {
		return this.locationService.getLocationById(id);
	}
	
	@PostMapping("/locations/addNew")
	public String addNew(Location l) {
		this.locationService.addNew(l);
		return "redirect:/locations";
	}
	
	@RequestMapping(value = "/locations/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Location l) {
		this.locationService.update(l);
		return "redirect:/locations";
	}
	
	@RequestMapping(value = "/locations/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.locationService.deleteById(id);
		return "redirect:/locations";
	}
}
