package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.VehicleMaintenance;
import com.hokhanh.fleetapp.repositories.VehicleMaintenanceRepository;



@Service
public class VehicleMainenanceService {
	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	public List<VehicleMaintenance> getVehicleMainenances() {
		return vehicleMaintenanceRepository.findAll();
	}

	public void addNew(VehicleMaintenance l) {
		try {
			this.vehicleMaintenanceRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.vehicleMaintenanceRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(VehicleMaintenance l) {
		try {
			this.vehicleMaintenanceRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VehicleMaintenance getVehicleMainenanceById(Integer id) {
		try {
			return this.vehicleMaintenanceRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
