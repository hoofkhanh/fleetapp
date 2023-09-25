package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Location;
import com.hokhanh.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}

	public void addNew(Location l) {
		try {
			this.locationRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.locationRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Location l) {
		try {
			this.locationRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Location getLocationById(Integer id) {
		try {
			return this.locationRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
