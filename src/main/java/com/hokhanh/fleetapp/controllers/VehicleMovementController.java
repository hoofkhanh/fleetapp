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

import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.models.Vehicle;
import com.hokhanh.fleetapp.models.VehicleMovement;
import com.hokhanh.fleetapp.services.LocationService;
import com.hokhanh.fleetapp.services.VehicleMovementService;
import com.hokhanh.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {
	
	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired
	private VehicleService vehicleService ;
	
	@Autowired
	private LocationService locationService ;

	
	@GetMapping("/vehiclemovements")
	public String getAll(Model m) {
		List<VehicleMovement> vehicleMovement =  this.vehicleMovementService.getVehicleMainenances();
		List<Vehicle> vehicles =  this.vehicleService.vehicles();
		List<Location> locations  =  this.locationService.getLocations();
		m.addAttribute("vehicleMovementList", vehicleMovement);
		m.addAttribute("vehicleList", vehicles);
		m.addAttribute("locationList", locations);
		return "VehicleMovement";
	}
	
	@GetMapping("vehiclemovements/getById")
	@ResponseBody
	public VehicleMovement getById(Integer id) {
		return this.vehicleMovementService.getVehicleMainenanceById(id);
	}
	
	@PostMapping("/vehiclemovements/addNew")
	public String addNew(VehicleMovement l) {
		this.vehicleMovementService.addNew(l);
		return "redirect:/vehiclemovements";
	}
	
	@RequestMapping(value = "/vehiclemovements/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(VehicleMovement l) {
		this.vehicleMovementService.update(l);
		return "redirect:/vehiclemovements";
	}
	
	@RequestMapping(value = "/vehiclemovements/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleMovementService.deleteById(id);
		return "redirect:/vehiclemovements";
	}
}
