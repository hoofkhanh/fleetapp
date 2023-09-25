package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Contact;
import com.hokhanh.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getContacts(){
		return this.contactRepository.findAll();
	}

	public void addNew(Contact Contact) {
		try {
			this.contactRepository.save(Contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Contact getContactById(Integer id) {
		return this.contactRepository.findById(id).orElse(null);
	}

	public void updateContact(Contact Contact) {
		try {
			this.contactRepository.save(Contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteContactById(Integer id) {
		try {
			this.contactRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
