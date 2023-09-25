package com.hokhanh.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hokhanh.fleetapp.models.Client;
import com.hokhanh.fleetapp.models.VehicleModel;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {

}
