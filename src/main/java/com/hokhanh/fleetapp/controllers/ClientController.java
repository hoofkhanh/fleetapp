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
import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.services.ClientService;
import com.hokhanh.fleetapp.services.CountryService;
import com.hokhanh.fleetapp.services.StateService;

@Controller
public class ClientController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private ClientService clientService ;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/clients")
	public String getAll(Model m) {
		List<Country> countrylist = this.countryService.getCountries();
		List<Client> clients = this.clientService.getClients();
		List<State> states = this.stateService.getStates();
		m.addAttribute("countryList", countrylist);
		m.addAttribute("clientList", clients);
		m.addAttribute("stateList", states);
		
		return "Client";
	}
	
	@PostMapping("/clients/addNew")
	public String addNew(Client client) {
		this.clientService.addNew(client);
		return "redirect:/clients";
	}
	
	@GetMapping("/clients/getById")
	@ResponseBody
	public Client getClientById(Integer id) {
		return this.clientService.getClientById(id);	
	}
	
	@RequestMapping(value = "/clients/update", method = {RequestMethod.GET,RequestMethod.PUT})
	public String update(Client client) {
		this.clientService.updateClient(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value = "/clients/delete", method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(Integer id) {
		this.clientService.deleteClientById(id);
		return "redirect:/clients";
	}
}
