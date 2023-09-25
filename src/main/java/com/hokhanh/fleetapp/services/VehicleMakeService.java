package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.models.VehicleMake;
import com.hokhanh.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakeRepository.findAll();
	}

	public void addNew(VehicleMake l) {
		try {
			this.vehicleMakeRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.vehicleMakeRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(VehicleMake l) {
		try {
			this.vehicleMakeRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VehicleMake getById(Integer id) {
		try {
			return this.vehicleMakeRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
