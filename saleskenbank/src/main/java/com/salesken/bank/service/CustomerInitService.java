package com.salesken.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesken.bank.domain.Customer;
import com.salesken.bank.mapper.CustomerMapper;
import com.salesken.bank.repository.CustomerBankRepository;
import com.salesken.bank.repository.CustomerRepository;

@Service
@Transactional
public class CustomerInitService {

	private final CustomerRepository customerRepository;

	private final CustomerBankRepository customerBankRepository;

	public CustomerInitService(CustomerRepository customerRepository, CustomerBankRepository customerBankRepository) {
		this.customerRepository = customerRepository;
		this.customerBankRepository = customerBankRepository;
	}

	public void createCustomers() {

		customerRepository.deleteAll();

		List<Customer> customers = CustomerMapper.createCustomers();

		customerRepository.saveAll(customers);

		customerBankRepository.deleteAll();

	}
}
