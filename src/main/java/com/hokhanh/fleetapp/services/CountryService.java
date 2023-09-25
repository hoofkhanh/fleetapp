package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hokhanh.fleetapp.models.Country;
import com.hokhanh.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getCountries(){
		return this.countryRepository.findAll();
	}

	public void addNew(Country country) {
		try {
			this.countryRepository.save(country);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Country getCountryById(Integer id) {
		return this.countryRepository.findById(id).orElse(null);
	}

	public void updateCountry(Country country) {
		try {
			this.countryRepository.save(country);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCountryById(Integer id) {
		try {
			this.countryRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
