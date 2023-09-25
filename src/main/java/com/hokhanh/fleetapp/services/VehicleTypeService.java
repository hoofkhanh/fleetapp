package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.VehicleMake;
import com.hokhanh.fleetapp.models.VehicleType;
import com.hokhanh.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	public List<VehicleType> getVehicleTypes() {
		return vehicleTypeRepository.findAll();
	}

	public void addNew(VehicleType l) {
		try {
			this.vehicleTypeRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.vehicleTypeRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(VehicleType l) {
		try {
			this.vehicleTypeRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VehicleType getById(Integer id) {
		try {
			return this.vehicleTypeRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
