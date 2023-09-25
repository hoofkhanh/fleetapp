package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.JobTitle;
import com.hokhanh.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobtitleRepository;
	
	public List<JobTitle> getJobTitles() {
		return jobtitleRepository.findAll();
	}

	public void addNew(JobTitle l) {
		try {
			this.jobtitleRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			this.jobtitleRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(JobTitle l) {
		try {
			this.jobtitleRepository.save(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JobTitle getById(Integer id) {
		try {
			return this.jobtitleRepository.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
