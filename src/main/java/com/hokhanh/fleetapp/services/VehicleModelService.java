package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.VehicleModel;
import com.hokhanh.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();
	}

	public void addNew(VehicleModel l) {
		try {
			this.vehicleModelRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.vehicleModelRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(VehicleModel l) {
		try {
			this.vehicleModelRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VehicleModel getById(Integer id) {
		try {
			return this.vehicleModelRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
