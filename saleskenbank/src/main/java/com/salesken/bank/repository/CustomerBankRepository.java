package com.salesken.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesken.bank.domain.BankAccount;
import com.salesken.bank.domain.CustomerBank;

@Repository
public interface CustomerBankRepository extends JpaRepository<CustomerBank, Long> {

	void deleteByAccountId(Long accountId);
}
