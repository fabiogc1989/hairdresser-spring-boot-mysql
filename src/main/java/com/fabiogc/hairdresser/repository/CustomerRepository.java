package com.fabiogc.hairdresser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiogc.hairdresser.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
