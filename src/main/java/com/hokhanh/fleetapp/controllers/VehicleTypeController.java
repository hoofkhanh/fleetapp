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

import com.hokhanh.fleetapp.models.VehicleModel;
import com.hokhanh.fleetapp.models.VehicleType;
import com.hokhanh.fleetapp.services.VehicleModelService;
import com.hokhanh.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {	
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicletypes")
	public String getAll(Model m) {
		List<VehicleType> vehicleTypes =  this.vehicleTypeService.getVehicleTypes();
		m.addAttribute("vehicleTypeList", vehicleTypes);
		return "VehicleType";
	}
	
	@GetMapping("vehicletypes/getById")
	@ResponseBody
	public VehicleType getById(Integer id) {
		return this.vehicleTypeService.getById(id);
	}
	
	@PostMapping("/vehicletypes/addNew")
	public String addNew(VehicleType l) {
		this.vehicleTypeService.addNew(l);
		return "redirect:/vehicletypes";
	}
	
	@RequestMapping(value = "/vehicletypes/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(VehicleType l) {
		this.vehicleTypeService.update(l);
		return "redirect:/vehicletypes";
	}
	
	@RequestMapping(value = "/vehicletypes/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleTypeService.deleteById(id);
		return "redirect:/vehicletypes";
	}
}
