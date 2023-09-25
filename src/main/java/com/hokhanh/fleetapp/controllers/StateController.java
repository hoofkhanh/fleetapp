package com.hokhanh.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hokhanh.fleetapp.models.Country;
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/states")
	public String getStates(Model m) {
		List<State> stateList = this.stateService.getStates();
		List<Country> countryList = this.countryService.getCountries();
		m.addAttribute("stateList", stateList);
		m.addAttribute("countryList", countryList);
		return "State";
	}
	
	@PostMapping("/states/addNew")
	public String addNew(State state) {
		this.stateService.addNew(state);
		return "redirect:/states";
	}
	
	@GetMapping("/states/getById")
	@ResponseBody
	public State getStateById(Integer id) {
		return this.stateService.getStateById(id);	
	}
	
	@RequestMapping(value = "/states/update", method = {RequestMethod.GET,RequestMethod.PUT})
	public String update(State state) {
		this.stateService.updateState(state);
		return "redirect:/states";
	}
	
	@RequestMapping(value = "/states/delete", method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(Integer id) {
		this.stateService.deleteStateById(id);
		return "redirect:/states";
	}
}
