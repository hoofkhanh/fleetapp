package com.hokhanh.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hokhanh.fleetapp.models.JobTitle;
import com.hokhanh.fleetapp.models.VehicleStatus;
import com.hokhanh.fleetapp.services.JobTitleService;


@Controller
public class JobTitleController {
	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping("/jobtitles")
	public String getAll(Model m) {
		List<JobTitle> jobTitles =  this.jobTitleService.getJobTitles();
		m.addAttribute("jobTitleList", jobTitles);
		return "JobTitle";
	}
	
	@GetMapping("jobtitles/getById")
	@ResponseBody
	public JobTitle getById(Integer id) {
		return this.jobTitleService.getById(id);
	}
	
	@PostMapping("/jobtitles/addNew")
	public String addNew(JobTitle l) {
		this.jobTitleService.addNew(l);
		return "redirect:/jobtitles";
	}
	
	@RequestMapping(value = "/jobtitles/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(JobTitle l) {
		this.jobTitleService.update(l);
		return "redirect:/jobtitles";
	}
	
	@RequestMapping(value = "/jobtitles/delete", method = {RequestMethod.GET, RequestMethod.GET})
	public String deleteById(Integer id) {
		this.jobTitleService.deleteById(id);
		return "redirect:/jobtitles";
	}
}
