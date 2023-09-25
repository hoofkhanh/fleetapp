package com.hokhanh.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hokhanh.fleetapp.models.Client;
import com.hokhanh.fleetapp.models.VehicleHire;

public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {

}
