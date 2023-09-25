package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Vehicle;
import com.hokhanh.fleetapp.models.VehicleModel;
import com.hokhanh.fleetapp.repositories.VehicleModelRepository;
import com.hokhanh.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> vehicles(){
		return this.vehicleRepository.findAll();
	}

	public void addNew(Vehicle l) {
		try {
			this.vehicleRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.vehicleRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Vehicle l) {
		try {
			this.vehicleRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vehicle getById(Integer id) {
		try {
			return this.vehicleRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
