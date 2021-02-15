package com.salesken.bank.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.salesken.bank.domain.Customer;
import com.salesken.bank.enums.GenderEnum;

public class CustomerMapper {

	public static List<Customer> createCustomers() {
		Customer male = new Customer();
		male.setId(1L);
		male.setFirstName("Ram");
		male.setLastName("Mohan");
		male.setDob(LocalDate.now().minusDays(100));
		male.setGender(GenderEnum.MALE.getValue());
		Customer female = new Customer();
		female.setId(2L);
		female.setFirstName("Geetha");
		female.setLastName("Nair");
		female.setDob(LocalDate.now().minusDays(200));
		female.setGender(GenderEnum.FEMALE.getValue());
		Customer transgender = new Customer();
		transgender.setId(3L);
		transgender.setFirstName("Sajitha");
		transgender.setLastName("Kumar");
		transgender.setDob(LocalDate.now().minusDays(300));
		transgender.setGender(GenderEnum.TRANSGENDER.getValue());
		List<Customer> customers = new ArrayList<>();
		customers.add(male);
		customers.add(female);
		customers.add(transgender);
		return customers;
	}

	private CustomerMapper() {
		// private constructor
	}

}
