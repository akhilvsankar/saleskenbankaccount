package com.salesken.bank.enums;

public enum AccountTypeEnum {

	SAVINGS(1L), CURRENT(2L), JOINT(3L);

	AccountTypeEnum(Long value) {
		this.value = value;
	}

	private Long value;

	public Long getValue() {
		return value;
	}

}
