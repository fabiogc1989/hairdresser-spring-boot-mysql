package com.fabiogc.hairdresser.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabiogc.hairdresser.dto.BusinessSvcDTO;
import com.fabiogc.hairdresser.model.BusinessService;
import com.fabiogc.hairdresser.service.BusinessSvcService;

@RestController
@RequestMapping(value = "/services")
public class BusinessServiceController {
	
	@Autowired
	private BusinessSvcService service;
	
	@GetMapping
	public ResponseEntity<List<BusinessSvcDTO>> findAll(){
		List<BusinessSvcDTO> list = service
				.findAll()
				.stream()
				.map(x -> new BusinessSvcDTO(x))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BusinessSvcDTO> findById(@PathVariable int id) {
		BusinessService model = service.findById(id);
		BusinessSvcDTO dto = new BusinessSvcDTO(model);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>  deleteById(@PathVariable int id) {
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<BusinessSvcDTO> insert(@RequestBody BusinessSvcDTO modelDTO) {
		BusinessService model = service
				.insert(new BusinessService(modelDTO.getId(), modelDTO.getName(), modelDTO.getPrice()));
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(model.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new BusinessSvcDTO(model));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<BusinessSvcDTO> update(@PathVariable int id, @RequestBody BusinessSvcDTO modelDTO){
		service.update(new BusinessService(modelDTO.getId(), modelDTO.getName(), modelDTO.getPrice()));
		
		return ResponseEntity.ok().body(modelDTO);
	}
}
