package com.salesken.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesken.bank.domain.BankAccount;
import com.salesken.bank.service.dto.AccountDetailsDTO;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	@Query("SELECT new com.salesken.bank.service.dto.AccountDetailsDTO(b.id as accountId,"
			+ "b.accountNumber,b.accountType.id as accountTypeId,b.branchId) FROM BankAccount b  WHERE b.customerId=:customerId ")
	List<AccountDetailsDTO> getAccountsForCustomer(@Param("customerId") Long customerId);

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("UPDATE BankAccount SET branchId=:branchId,accountType.id=:accountTypeId WHERE id=:accountId ")
	void updateAccountDetails(@Param("accountId") Long accountId, @Param("accountTypeId") Long accountTypeId,
			@Param("branchId") Long branchId);
}
