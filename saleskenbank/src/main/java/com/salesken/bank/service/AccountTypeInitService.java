package com.salesken.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesken.bank.domain.LkpAccountType;
import com.salesken.bank.mapper.AccountTypeMapper;
import com.salesken.bank.repository.AccountTypeRepository;

@Service
@Transactional
public class AccountTypeInitService {

	private final AccountTypeRepository accountTypeRepository;

	public AccountTypeInitService(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}

	public void createAccountTypes() {
		accountTypeRepository.deleteAll();
		List<LkpAccountType> accountTypes = AccountTypeMapper.createAccountTypes();
		accountTypeRepository.saveAll(accountTypes);
	}

}
