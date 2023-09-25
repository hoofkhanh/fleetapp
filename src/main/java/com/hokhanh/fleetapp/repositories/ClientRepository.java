package com.hokhanh.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hokhanh.fleetapp.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
