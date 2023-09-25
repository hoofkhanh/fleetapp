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
import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.models.VehicleMake;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.StateService;
import com.hokhanh.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehiclemakes")
	public String getAll(Model m) {
		List<VehicleMake> vehicleMakes =  this.vehicleMakeService.getVehicleMakes();
		m.addAttribute("vehicleMakeList", vehicleMakes);
		return "VehicleMake";
	}
	
	@GetMapping("vehiclemakes/getById")
	@ResponseBody
	public VehicleMake getById(Integer id) {
		return this.vehicleMakeService.getById(id);
	}
	
	@PostMapping("/vehiclemakes/addNew")
	public String addNew(VehicleMake l) {
		this.vehicleMakeService.addNew(l);
		return "redirect:/vehiclemakes";
	}
	
	@RequestMapping(value = "/vehiclemakes/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(VehicleMake l) {
		this.vehicleMakeService.update(l);
		return "redirect:/vehiclemakes";
	}
	
	@RequestMapping(value = "/vehiclemakes/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleMakeService.deleteById(id);
		return "redirect:/vehiclemakes";
	}
}
