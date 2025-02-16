package com.fabiogc.hairdresser.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabiogc.hairdresser.dto.CustomerDTO;
import com.fabiogc.hairdresser.model.Customer;
import com.fabiogc.hairdresser.service.CustomerService;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll(){
		List<CustomerDTO> list = service
				.findAll()
				.stream()
				.map(x -> new CustomerDTO(x))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable int id){
		Customer model = service.findById(id);
		CustomerDTO modelDTO = new CustomerDTO(model);
		
		return ResponseEntity.ok().body(modelDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(int id){
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<CustomerDTO> insert(@RequestBody CustomerDTO modelDTO){
		Customer model = service
				.insert(new Customer(modelDTO.getId(), modelDTO.getFirstName(), modelDTO.getSurname(), modelDTO.getEmail()));
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(model.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new CustomerDTO(model));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> update(@PathVariable int id, @RequestBody CustomerDTO modelDTO) {
		service.update(new Customer(modelDTO.getId(), modelDTO.getFirstName(), modelDTO.getSurname(), modelDTO.getEmail()));
	
		return ResponseEntity.ok().body(modelDTO);
	}
}
