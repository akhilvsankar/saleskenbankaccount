package com.salesken.bank.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesken.bank.domain.BankAccount;
import com.salesken.bank.domain.CustomerBank;
import com.salesken.bank.mapper.BankAccountMapper;
import com.salesken.bank.repository.BankAccountRepository;
import com.salesken.bank.repository.CustomerBankRepository;
import com.salesken.bank.service.dto.AccountSaveDTO;
import com.salesken.bank.service.dto.AccountDetailsDTO;

@Service
@Transactional
public class BankAccountService {

	/** The Constant LIMIT. */
	private static final Long LIMIT = 1_000_000L;

	private final BankAccountRepository bankAccountRepository;

	private final CustomerBankRepository customerBankRepository;

	private final BankAccountMapper bankAccountMapper;

	public BankAccountService(BankAccountRepository bankAccountRepository,
			CustomerBankRepository customerBankRepository, BankAccountMapper bankAccountMapper) {
		this.bankAccountRepository = bankAccountRepository;
		this.customerBankRepository = customerBankRepository;
		this.bankAccountMapper = bankAccountMapper;
	}

	public String createAccount(@Valid AccountSaveDTO accountCreateDTO) {
		String accountNumber = generateUniqueAccountNumber(accountCreateDTO.getCustomerId());
		BankAccount bankAccount = bankAccountMapper.toEntity(accountCreateDTO);
		bankAccount.setAccountNumber(accountNumber);
		bankAccount = bankAccountRepository.save(bankAccount);
		saveCustomerBank(accountCreateDTO, bankAccount);
		return accountNumber;
	}

	private void saveCustomerBank(AccountSaveDTO accountCreateDTO, BankAccount bankAccount) {
		CustomerBank customerBank = new CustomerBank();
		customerBank.setAccountId(bankAccount.getId());
		customerBank.setCustomerId(accountCreateDTO.getCustomerId());
		customerBankRepository.save(customerBank);
	}

	private static String generateUniqueAccountNumber(Long customerId) {
		final Long uniqueId = System.currentTimeMillis() % BankAccountService.LIMIT;
		Long accountNumber = uniqueId + customerId;
		return accountNumber.toString();
	}

	public List<AccountDetailsDTO> getAccounts(Long customerId) {
		return bankAccountRepository.getAccountsForCustomer(customerId);
	}

	public boolean updateAccount(AccountSaveDTO accountSaveDTO) {
		bankAccountRepository.updateAccountDetails(accountSaveDTO.getAccountId(), accountSaveDTO.getAccountTypeId(),
				accountSaveDTO.getBranchId());
		return true;

	}

	public boolean deleteAccount(Long accountId) {
		bankAccountRepository.deleteById(accountId);
		customerBankRepository.deleteByAccountId(accountId);
		return true;
	}

}
