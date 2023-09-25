package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.InvoiceStatus;
import com.hokhanh.fleetapp.models.VehicleType;
import com.hokhanh.fleetapp.repositories.InvoiceStatusRepository;
import com.hokhanh.fleetapp.repositories.VehicleTypeRepository;

@Service
public class InvoiceStatusService {
	
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	public List<InvoiceStatus> getVehicleTypes() {
		return invoiceStatusRepository.findAll();
	}

	public void addNew(InvoiceStatus l) {
		try {
			this.invoiceStatusRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.invoiceStatusRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(InvoiceStatus l) {
		try {
			this.invoiceStatusRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InvoiceStatus getById(Integer id) {
		try {
			return this.invoiceStatusRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
