package com.fabiogc.hairdresser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiogc.hairdresser.model.Customer;
import com.fabiogc.hairdresser.repository.CustomerRepository;
import com.fabiogc.hairdresser.service.exception.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> findAll() {
		return repository.findAll();
	}
	
	public Customer findById(int id) {
		Optional<Customer> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public Customer insert(Customer model) {
		return repository.save(model);
	}
	
	public Customer update(Customer model) {
		return repository.save(model);
	}
}
