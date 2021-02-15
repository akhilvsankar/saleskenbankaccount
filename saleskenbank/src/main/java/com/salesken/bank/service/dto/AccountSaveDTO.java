package com.salesken.bank.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.salesken.bank.service.OnCreate;
import com.salesken.bank.service.OnUpdate;

public class AccountSaveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(groups = OnUpdate.class, message = "Account Id cannot be null")
	@Null(groups = OnCreate.class, message = "Account Id should be null")
	private Long accountId;

	@NotNull(message = "Customer Id cannot be null")
	private Long customerId;

	@NotNull(message = "Account Type Id cannot be null")
	private Long accountTypeId;

	@NotNull(message = "Branch Id cannot be null")
	private Long branchId;

	public AccountSaveDTO() {
		// Constructor
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((accountTypeId == null) ? 0 : accountTypeId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		AccountSaveDTO other = (AccountSaveDTO) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
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
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountCreateDTO [accountId=" + accountId + ", customerId=" + customerId + ", accountTypeId="
				+ accountTypeId + ", branchId=" + branchId + "]";
	}

}
