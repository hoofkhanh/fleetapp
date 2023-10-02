package com.hokhanh.fleetapp.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hokhanh.fleetapp.models.Role;
import com.hokhanh.fleetapp.models.User;
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "SELECT * FROM role WHERE role_id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)", nativeQuery = true)
	List<Role> getUserNotRoles( Integer user_id);

	
}
