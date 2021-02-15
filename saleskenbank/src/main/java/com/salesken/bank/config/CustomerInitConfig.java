package com.salesken.bank.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesken.bank.service.AccountTypeInitService;
import com.salesken.bank.service.CustomerInitService;

/**
 * The Class ApplicableRatePerGramInitConfig.
 */
@Component
public class CustomerInitConfig {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(CustomerInitConfig.class);

	/** The applicable rate per gram init service. */
	@Autowired
	private CustomerInitService customerInitService;

	@Autowired
	private AccountTypeInitService accountTypeInitService;

	/**
	 * Inits the.
	 */

	@PostConstruct
	public void init() {
		customerInitService.createCustomers();
		LOG.debug("Customers Created");
		accountTypeInitService.createAccountTypes();
		LOG.debug("Account Types Created");
	}

}
