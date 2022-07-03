package com.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customermanagement.model.Customer;
import com.customermanagement.service.ICustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	ICustomerService customerService;

	@Autowired
	CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customer-list";
	}

	@RequestMapping("/add")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute(customer);
		return "customer-form";
	}

	@RequestMapping("/save")
	public String saveOrUpdate(@RequestParam("id") long id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer customer;
		if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty()) {
			if (id == 0) {
				// create new record
				customer = new Customer(firstName, lastName, email);
			} else {
				// update the record
				customer = customerService.findById(id);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setEmail(email);
			}
			customerService.save(customer);
			return "redirect:./list";
		}
		return "redirect:./add";
	}

	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("id") long id, Model model) {
		Customer customer = customerService.findById(id);
		model.addAttribute(customer);
		return "customer-form";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") long id) {
		customerService.deleteById(id);
		return "redirect:./list";
	}
}
