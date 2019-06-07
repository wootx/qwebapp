package com.account.qwebapp.account;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
/*import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;*/

@Data
@Entity
/*@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
*/public class Account {
	
	// Name of the attribute could be accountId instead of id.
	@NotNull
	private @Id @GeneratedValue Long id;
	@NotNull
	@Size(min = 1, max = 60)
	private String accountType;
	@NotNull
	@Size(min = 1, max = 8)
	private String accountNickName;
	
	private boolean preferredAccount;
	
	@NotNull
	private Long profileId;
	
	private String userId;
	
	private BigDecimal balance;
	
	@NotNull(message = "{account.currency.notNull}")
	@Size(min = 3, max = 3, message = "{account.currency.size}")
	private String currency;
	
	
	public Account(){}
	
	public Account(String accountType, String accountNickName, boolean preferredAccount, 
			Long profileId, String userId, BigDecimal balance, String currency)
	{
		this.accountType = accountType;
		this.accountNickName = accountNickName;
		this.preferredAccount = preferredAccount;
		this.profileId = profileId;
		this.userId = userId;
		this.balance = balance;
		this.currency = currency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNickName() {
		return accountNickName;
	}

	public void setAccountNickName(String accountNickName) {
		this.accountNickName = accountNickName;
	}

	public boolean isPreferredAccount() {
		return preferredAccount;
	}

	public void setPreferredAccount(boolean preferredAccount) {
		this.preferredAccount = preferredAccount;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNickName == null) ? 0 : accountNickName.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (preferredAccount ? 1231 : 1237);
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Account other = (Account) obj;
		if (accountNickName == null) {
			if (other.accountNickName != null)
				return false;
		} else if (!accountNickName.equals(other.accountNickName))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (preferredAccount != other.preferredAccount)
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", accountNickName=" + accountNickName
				+ ", preferredAccount=" + preferredAccount + ", profileId=" + profileId + ", userId=" + userId
				+ ", balance=" + balance + ", currency=" + currency + "]";
	}
	
	

}

