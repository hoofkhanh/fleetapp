package com.hokhanh.fleetapp.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.hokhanh.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {
	
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehiclemodels")
	public String getAll(Model m) {
		List<VehicleModel> VehicleModels =  this.vehicleModelService.getVehicleModels();
		m.addAttribute("vehicleModelList", VehicleModels);
		return "VehicleModel";
	}
	
	@GetMapping("vehiclemodels/getById")
	@ResponseBody
	public VehicleModel getById(Integer id) {
		return this.vehicleModelService.getById(id);
	}
	
	@PostMapping("/vehiclemodels/addNew")
	public String addNew(VehicleModel l) {
		this.vehicleModelService.addNew(l);
		return "redirect:/vehiclemodels";
	}
	
	@RequestMapping(value = "/vehiclemodels/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(VehicleModel l) throws ParseException {
		this.vehicleModelService.update(l);
		return "redirect:/vehiclemodels";
	}
	
	@RequestMapping(value = "/vehiclemodels/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.vehicleModelService.deleteById(id);
		return "redirect:/vehiclemodels";
	}
}
