package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.VehicleStatus;
import com.hokhanh.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	public List<VehicleStatus> getVehicleStatuss() {
		return vehicleStatusRepository.findAll();
	}

	public void addNew(VehicleStatus l) {
		try {
			this.vehicleStatusRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.vehicleStatusRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(VehicleStatus l) {
		try {
			this.vehicleStatusRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VehicleStatus getById(Integer id) {
		try {
			return this.vehicleStatusRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
