package com.salesken.bank.mapper;

import java.util.ArrayList;
import java.util.List;

import com.salesken.bank.domain.LkpAccountType;
import com.salesken.bank.enums.AccountTypeEnum;

public class AccountTypeMapper {

	public static List<LkpAccountType> createAccountTypes() {
		List<LkpAccountType> accountTypes = new ArrayList<>();
		LkpAccountType savings = new LkpAccountType();
		savings.setId(AccountTypeEnum.SAVINGS.getValue());
		savings.setName("Savings");
		LkpAccountType current = new LkpAccountType();
		current.setId(AccountTypeEnum.CURRENT.getValue());
		current.setName("Current");
		LkpAccountType joint = new LkpAccountType();
		joint.setId(AccountTypeEnum.JOINT.getValue());
		joint.setName("Joint");
		accountTypes.add(savings);
		accountTypes.add(current);
		accountTypes.add(joint);
		return accountTypes;
	}

	private AccountTypeMapper() {
		// Constructor
	}
}
