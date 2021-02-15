package com.salesken.bank.enums;

public enum GenderEnum {

	MALE("Male"), FEMALE("Female"), TRANSGENDER("Transgender");

	GenderEnum(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

}
