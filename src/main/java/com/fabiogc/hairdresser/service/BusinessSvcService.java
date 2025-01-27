package com.fabiogc.hairdresser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiogc.hairdresser.model.BusinessService;
import com.fabiogc.hairdresser.repository.BusinessServiceRepository;
import com.fabiogc.hairdresser.service.exception.ObjectNotFoundException;

@Service
public class BusinessSvcService {
	
	@Autowired
	private BusinessServiceRepository repository;
	
	public List<BusinessService> findAll() {
		return repository.findAll();
	}
	
	public BusinessService findById(int id) {
		Optional<BusinessService> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objectnot found"));
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public BusinessService insert(BusinessService model) {
		return repository.save(model);
	}
	
	public BusinessService update(BusinessService model) {
		return repository.save(model);
	}

}
