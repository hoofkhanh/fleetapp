package com.hokhanh.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hokhanh.fleetapp.models.Client;
import com.hokhanh.fleetapp.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
