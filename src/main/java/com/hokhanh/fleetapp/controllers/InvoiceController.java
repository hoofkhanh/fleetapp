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
import com.hokhanh.fleetapp.models.Invoice;
import com.hokhanh.fleetapp.models.InvoiceStatus;
import com.hokhanh.fleetapp.services.ClientService;
import com.hokhanh.fleetapp.services.InvoiceService;
import com.hokhanh.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoices")
	public String getAll(Model m) {
		List<Invoice> invoices =  this.invoiceService.getInvoices();
		List<Client> clients = this.clientService.getClients();
		List<InvoiceStatus> invoiceStatus = this.invoiceStatusService.getVehicleTypes();
		m.addAttribute("invoiceList", invoices);
		m.addAttribute("invoiceStatusList", invoiceStatus);
		m.addAttribute("clientList", clients);
		return "Invoice";
	}
	
	@GetMapping("invoices/getById")
	@ResponseBody
	public Invoice getById(Integer id) {
		return this.invoiceService.getInvoiceById(id);
	}
	
	@PostMapping("/invoices/addNew")
	public String addNew(Invoice l) {
		this.invoiceService.addNew(l);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value = "/invoices/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Invoice l) {
		this.invoiceService.updateInvoice(l);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value = "/invoices/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.invoiceService.deleteInvoiceById(id);
		return "redirect:/invoices";
	}
}
