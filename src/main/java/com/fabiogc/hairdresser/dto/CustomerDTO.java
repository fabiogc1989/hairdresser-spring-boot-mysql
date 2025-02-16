package com.fabiogc.hairdresser.dto;

import com.fabiogc.hairdresser.model.Customer;

public class CustomerDTO {
	private Integer id;
	
	private String firstName;
	
	private String surname;
	
	private String email;
	
	private Integer phoneNumber;
	
	public CustomerDTO(String firstName, String surname, String email) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
	}
	
	public CustomerDTO(Integer id, String firstName, String surname, String email) {
		this(firstName, surname, email);
		this.id = id;
	}
	
	public CustomerDTO(Customer model) {
		this(model.getId(), model.getFirstName(), model.getSurname(), model.getEmail());
	}
	
	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
