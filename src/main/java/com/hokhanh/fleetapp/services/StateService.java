package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.State;
import com.hokhanh.fleetapp.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	public List<State> getStates(){
		return this.stateRepository.findAll();
	}

	public void addNew(State state) {
		try {
			this.stateRepository.save(state);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public State getStateById(Integer id) {
		return this.stateRepository.findById(id).orElse(null);
	}

	public void updateState(State state) {
		try {
			this.stateRepository.save(state);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStateById(Integer id) {
		try {
			this.stateRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
