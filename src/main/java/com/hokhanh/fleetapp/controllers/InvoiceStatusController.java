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

import com.hokhanh.fleetapp.models.EmployeeType;
import com.hokhanh.fleetapp.models.InvoiceStatus;
import com.hokhanh.fleetapp.services.EmployeeTypeService;
import com.hokhanh.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoicestatuses")
	public String getAll(Model m) {
		List<InvoiceStatus> invoiceStatus =  this.invoiceStatusService.getVehicleTypes();
		m.addAttribute("invoiceStatusList", invoiceStatus);
		return "InvoiceStatus";
	}
	
	@GetMapping("invoicestatuses/getById")
	@ResponseBody
	public InvoiceStatus getById(Integer id) {
		return this.invoiceStatusService.getById(id);
	}
	
	@PostMapping("/invoicestatuses/addNew")
	public String addNew(InvoiceStatus l) {
		this.invoiceStatusService.addNew(l);
		return "redirect:/invoicestatuses";
	}
	
	@RequestMapping(value = "/invoicestatuses/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(InvoiceStatus l) {
		this.invoiceStatusService.update(l);
		return "redirect:/invoicestatuses";
	}
	
	@RequestMapping(value = "/invoicestatuses/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.invoiceStatusService.deleteById(id);
		return "redirect:/invoicestatuses";
	}
}
