package com.hokhanh.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hokhanh.fleetapp.models.Client;
import com.hokhanh.fleetapp.models.VehicleMaintenance;

public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance, Integer> {

}
