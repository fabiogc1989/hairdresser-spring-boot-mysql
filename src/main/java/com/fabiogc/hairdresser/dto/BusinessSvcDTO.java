package com.fabiogc.hairdresser.dto;

import com.fabiogc.hairdresser.model.BusinessService;

public class BusinessSvcDTO {
	private Integer id;
	
	private String name;
	
	private Double price;
	
	public BusinessSvcDTO() {
	}
	
	public BusinessSvcDTO(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public BusinessSvcDTO(Integer id, String name, Double price) {
		this(name, price);
		this.id = id;
	}
	
	public BusinessSvcDTO(BusinessService model) {
		this(model.getId(), model.getName(), model.getPrice());
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
