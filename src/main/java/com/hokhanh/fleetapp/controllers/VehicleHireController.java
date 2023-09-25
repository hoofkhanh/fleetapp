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

import com.hokhanh.fleetapp.models.Client;
import com.hokhanh.fleetapp.models.Country;
import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.models.Vehicle;
import com.hokhanh.fleetapp.models.VehicleHire;
import com.hokhanh.fleetapp.services.ClientService;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.LocationService;
import com.hokhanh.fleetapp.services.StateService;
import com.hokhanh.fleetapp.services.VehicleHireService;
import com.hokhanh.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {
	
	@Autowired
	private VehicleHireService vehicleHireService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/vehiclehires")
	public String getAll(Model m) {
		List<VehicleHire> vehicleHires =  this.vehicleHireService.getVehicleHires();
		List<Vehicle> vehicles =  this.vehicleService.vehicles();
		List<Client> clients =  this.clientService.getClients();
		List<Location> locations = this.locationService.getLocations();
		m.addAttribute("vehicleHireList", vehicleHires);
		m.addAttribute("vehicleList", vehicles);
		m.addAttribute("clientList", clients);
		m.addAttribute("locationList", locations);
		return "VehicleHire";
	}
	
	@GetMapping("vehiclehires/getById")
	@ResponseBody
	public VehicleHire getById(Integer id) {
		return this.vehicleHireService.getVehicleHireById(id);
	}
	
	@PostMapping("/vehiclehires/addNew")
	public String addNew(VehicleHire l) {
		this.vehicleHireService.addNew(l);
		return "redirect:/vehiclehires";
	}
	
	@RequestMapping(value = "/vehiclehires/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(VehicleHire l) {
		this.vehicleHireService.updateVehicleHire(l);
		return "redirect:/vehiclehires";
	}
	
	@RequestMapping(value = "/vehiclehires/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleHireService.deleteVehicleHireById(id);
		return "redirect:/vehiclehires";
	}
}
