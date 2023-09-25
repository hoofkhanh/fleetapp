package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Supplier;
import com.hokhanh.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<Supplier> getSuppliers(){
		return this.supplierRepository.findAll();
	}

	public void addNew(Supplier supplier) {
		try {
			this.supplierRepository.save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Supplier getSupplierById(Integer id) {
		return this.supplierRepository.findById(id).orElse(null);
	}

	public void updateSupplier(Supplier supplier) {
		try {
			this.supplierRepository.save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSupplierById(Integer id) {
		try {
			this.supplierRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
