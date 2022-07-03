package com.customermanagement.service;

import java.util.List;

import com.customermanagement.model.Customer;

public interface ICustomerService {
	List<Customer> findAll();

	Customer findById(long id);

	void deleteById(long id);

	void save(Customer customer);
}
