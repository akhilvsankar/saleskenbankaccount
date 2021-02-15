package com.salesken.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesken.bank.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}