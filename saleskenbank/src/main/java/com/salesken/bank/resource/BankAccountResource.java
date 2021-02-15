package com.salesken.bank.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.bank.service.BankAccountService;
import com.salesken.bank.service.OnCreate;
import com.salesken.bank.service.OnUpdate;
import com.salesken.bank.service.dto.AccountDetailsDTO;
import com.salesken.bank.service.dto.AccountSaveDTO;
import com.salesken.bank.web.rest.errors.BadRequestAlertException;

@RestController
@RequestMapping("/api")
public class BankAccountResource {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountResource.class);

	private BankAccountService bankAccountService;

	public BankAccountResource(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}

	@PostMapping("/account/create")
	public ResponseEntity<String> createAccount(@RequestBody @Validated(OnCreate.class) AccountSaveDTO accountCreateDTO,
			Errors errors) throws BadRequestAlertException {
		BankAccountResource.LOGGER.debug("REST request to create bank account details : {}", accountCreateDTO);
		if (errors.hasGlobalErrors()) {

			throw new BadRequestAlertException(errors.getGlobalError().getDefaultMessage());

		}
		if (errors.hasFieldErrors()) {

			throw new BadRequestAlertException(errors.getFieldError().getDefaultMessage());

		}

		String accountNumber = bankAccountService.createAccount(accountCreateDTO);
		return ResponseEntity.ok().body(accountNumber);

	}

	@GetMapping("/account/get/{customerId}")
	public ResponseEntity<List<AccountDetailsDTO>> getAccounts(@PathVariable Long customerId)
			throws BadRequestAlertException {
		BankAccountResource.LOGGER.debug("REST request to get bank account numbers for the customer id : {}",
				customerId);
		List<AccountDetailsDTO> accountDetails = bankAccountService.getAccounts(customerId);
		return ResponseEntity.ok().body(accountDetails);
	}

	@PutMapping("/account/update")
	public ResponseEntity<Boolean> updateAccount(
			@RequestBody @Validated(OnUpdate.class) AccountSaveDTO accountCreateDTO, Errors errors)
			throws BadRequestAlertException {
		BankAccountResource.LOGGER.debug("REST request to update bank account details : {}", accountCreateDTO);
		if (errors.hasGlobalErrors()) {

			throw new BadRequestAlertException(errors.getGlobalError().getDefaultMessage());

		}
		if (errors.hasFieldErrors()) {

			throw new BadRequestAlertException(errors.getFieldError().getDefaultMessage());

		}

		boolean response = bankAccountService.updateAccount(accountCreateDTO);
		return ResponseEntity.ok().body(response);

	}

	@DeleteMapping("/account/delete/{accountId}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable Long accountId) {
		BankAccountResource.LOGGER.debug("REST request to delete bank account for the account id: {}", accountId);
		boolean response = bankAccountService.deleteAccount(accountId);
		return ResponseEntity.ok().body(response);
	}

}
