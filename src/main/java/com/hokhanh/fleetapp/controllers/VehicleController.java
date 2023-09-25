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
import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.models.Vehicle;
import com.hokhanh.fleetapp.models.VehicleMake;
import com.hokhanh.fleetapp.models.VehicleModel;
import com.hokhanh.fleetapp.models.VehicleStatus;
import com.hokhanh.fleetapp.models.VehicleType;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.EmployeeService;
import com.hokhanh.fleetapp.services.LocationService;
import com.hokhanh.fleetapp.services.StateService;
import com.hokhanh.fleetapp.services.VehicleMakeService;
import com.hokhanh.fleetapp.services.VehicleModelService;
import com.hokhanh.fleetapp.services.VehicleService;
import com.hokhanh.fleetapp.services.VehicleStatusService;
import com.hokhanh.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicles")
	public String getAll(Model m) {
		List<Vehicle> vehicles =  this.vehicleService.vehicles();
		List<Location> locations =  this.locationService.getLocations();
		List<VehicleModel> vehicleModels =  this.vehicleModelService.getVehicleModels();
		List<VehicleStatus> vehicleStatus =  this.vehicleStatusService.getVehicleStatuss();
		List<VehicleMake> vehicleMakes =  this.vehicleMakeService.getVehicleMakes();
		List<VehicleType> vehicleTypes =  this.vehicleTypeService.getVehicleTypes();
		List<Employee> employees =  this.employeeService.getEmployees();
		m.addAttribute("vehicleList", vehicles);
		m.addAttribute("locationList", locations);
		m.addAttribute("vehicleModelList", vehicleModels);
		m.addAttribute("vehicleStatusList", vehicleStatus);
		m.addAttribute("vehicleMakeList", vehicleMakes);
		m.addAttribute("vehicleTypeList", vehicleTypes);
		m.addAttribute("employeeList", employees);
		return "Vehicle";
	}
	
	@GetMapping("vehicles/getById")
	@ResponseBody
	public Vehicle getById(Integer id) {
		return this.vehicleService.getById(id);
	}
	
	@PostMapping("/vehicles/addNew")
	public String addNew(Vehicle l) {
		this.vehicleService.addNew(l);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value = "/vehicles/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Vehicle l) {
		this.vehicleService.update(l);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value = "/vehicles/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleService.deleteById(id);
		return "redirect:/vehicles";
	}
}
