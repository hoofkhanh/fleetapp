package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.VehicleMovement;
import com.hokhanh.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	public List<VehicleMovement> getVehicleMainenances() {
		return vehicleMovementRepository.findAll();
	}

	public void addNew(VehicleMovement l) {
		try {
			this.vehicleMovementRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.vehicleMovementRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(VehicleMovement l) {
		try {
			this.vehicleMovementRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VehicleMovement getVehicleMainenanceById(Integer id) {
		try {
			return this.vehicleMovementRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
