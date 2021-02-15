package com.salesken.bank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.salesken.bank.domain.BankAccount;
import com.salesken.bank.service.dto.AccountSaveDTO;

@Mapper(componentModel = "spring")
public interface BankAccountMapper extends EntityMapper<AccountSaveDTO, BankAccount> {

	@Mapping(source = "accountTypeId", target = "accountType.id")
	BankAccount toEntity(AccountSaveDTO accountCreateDTO);

}
