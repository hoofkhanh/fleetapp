package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.VehicleHire;
import com.hokhanh.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	public List<VehicleHire> getVehicleHires(){
		return this.vehicleHireRepository.findAll();
	}

	public void addNew(VehicleHire vehicleHire) {
		try {
			this.vehicleHireRepository.save(vehicleHire);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public VehicleHire getVehicleHireById(Integer id) {
		return this.vehicleHireRepository.findById(id).orElse(null);
	}

	public void updateVehicleHire(VehicleHire vehicleHire) {
		try {
			this.vehicleHireRepository.save(vehicleHire);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteVehicleHireById(Integer id) {
		try {
			this.vehicleHireRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
