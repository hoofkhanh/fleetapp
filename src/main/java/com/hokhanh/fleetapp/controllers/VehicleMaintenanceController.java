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
import com.hokhanh.fleetapp.models.Vehicle;
import com.hokhanh.fleetapp.models.VehicleMaintenance;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.StateService;
import com.hokhanh.fleetapp.services.SupplierService;
import com.hokhanh.fleetapp.services.VehicleMainenanceService;
import com.hokhanh.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
	
	@Autowired
	private VehicleMainenanceService vehicleMaintenanceService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehiclemaintenances")
	public String getAll(Model m) {
		List<VehicleMaintenance> vehicleMaintenances =  this.vehicleMaintenanceService.getVehicleMainenances();
		List<Vehicle> vehicles =  this.vehicleService.vehicles();
		List<Supplier> suppliers =  this.supplierService.getSuppliers();
		m.addAttribute("vehicleMaintenanceList", vehicleMaintenances);
		m.addAttribute("vehicleList", vehicles);
		m.addAttribute("supplierList", suppliers);
		return "VehicleMaintenance";
	}
	
	@GetMapping("vehiclemaintenances/getById")
	@ResponseBody
	public VehicleMaintenance getById(Integer id) {
		return this.vehicleMaintenanceService.getVehicleMainenanceById(id);
	}
	
	@PostMapping("/vehiclemaintenances/addNew")
	public String addNew(VehicleMaintenance l) {
		this.vehicleMaintenanceService.addNew(l);
		return "redirect:/vehiclemaintenances";
	}
	
	@RequestMapping(value = "/vehiclemaintenances/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(VehicleMaintenance l) {
		this.vehicleMaintenanceService.update(l);
		return "redirect:/vehiclemaintenances";
	}
	
	@RequestMapping(value = "/vehiclemaintenances/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleMaintenanceService.deleteById(id);
		return "redirect:/vehiclemaintenances";
	}
}
