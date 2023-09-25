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

import com.hokhanh.fleetapp.models.VehicleStatus;
import com.hokhanh.fleetapp.models.VehicleType;
import com.hokhanh.fleetapp.services.VehicleStatusService;
import com.hokhanh.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleStatusController {
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@GetMapping("/vehiclestatuses")
	public String getAll(Model m) {
		List<VehicleStatus> vehicleStatus =  this.vehicleStatusService.getVehicleStatuss();
		m.addAttribute("vehicleStatusList", vehicleStatus);
		return "VehicleStatus";
	}
	
	@GetMapping("vehiclestatuses/getById")
	@ResponseBody
	public VehicleStatus getById(Integer id) {
		return this.vehicleStatusService.getById(id);
	}
	
	@PostMapping("/vehiclestatuses/addNew")
	public String addNew(VehicleStatus l) {
		this.vehicleStatusService.addNew(l);
		return "redirect:/vehiclestatuses";
	}
	
	@RequestMapping(value = "/vehiclestatuses/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(VehicleStatus l) {
		this.vehicleStatusService.update(l);
		return "redirect:/vehiclestatuses";
	}
	
	@RequestMapping(value = "/vehiclestatuses/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleStatusService.deleteById(id);
		return "redirect:/vehiclestatuses";
	}
}
