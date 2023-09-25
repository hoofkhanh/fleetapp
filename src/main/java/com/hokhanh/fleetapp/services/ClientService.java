package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Client;
import com.hokhanh.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getClients(){
		return this.clientRepository.findAll();
	}

	public void addNew(Client client) {
		try {
			this.clientRepository.save(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Client getClientById(Integer id) {
		return this.clientRepository.findById(id).orElse(null);
	}

	public void updateClient(Client client) {
		try {
			this.clientRepository.save(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteClientById(Integer id) {
		try {
			this.clientRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	