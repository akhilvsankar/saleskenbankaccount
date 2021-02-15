
package com.salesken.bank.web.rest.errors;

public class BadRequestAlertException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadRequestAlertException(String defaultMessage) {
		super(defaultMessage);
	}

}
