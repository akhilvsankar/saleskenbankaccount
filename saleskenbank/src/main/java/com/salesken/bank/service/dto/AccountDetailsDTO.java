package com.salesken.bank.service.dto;

import java.io.Serializable;

public class AccountDetailsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long accountId;

	private String accountNumber;

	private Long accountTypeId;

	private Long branchId;

	public AccountDetailsDTO() {
		// constructor
	}

	public AccountDetailsDTO(Long accountId, String accountNumber, Long accountTypeId, Long branchId) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountTypeId = accountTypeId;
		this.branchId = branchId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountTypeId == null) ? 0 : accountTypeId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDetailsDTO other = (AccountDetailsDTO) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountTypeId == null) {
			if (other.accountTypeId != null)
				return false;
		} else if (!accountTypeId.equals(other.accountTypeId))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountDetailsDTO [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountTypeId="
				+ accountTypeId + ", branchId=" + branchId + "]";
	}

}
