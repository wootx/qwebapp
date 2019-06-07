package com.account.qwebapp.account;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.account.qwebapp.account.exception.AccountIncorrectInputException;
import com.account.qwebapp.account.exception.AccountNotFoundException;
import com.account.qwebapp.account.exception.AccountProfileNotFoundException;

@Component
public class AccountImpl {

	private static final Logger logger = LoggerFactory.getLogger(AccountImpl.class);

	@Autowired
	private AccountRepository repositoryAccount;
	
	@Autowired
	private AccountProfileRepository repositoryAccountProfile;

	public AccountImpl() {
		super();

	}

	// All accounts for user
	
	public List<Account> allAccountsforUser(String userid){

		List<Account> lst = repositoryAccount.findByUserId(userid);
		if (null == lst || lst.isEmpty()) {
			logger.error("Account does not exist for this userid ", userid);
			throw new AccountNotFoundException(userid);
		}
		return lst;
	}

	// Single account

	public Account findAccount(@RequestParam("id") Long id) {
		if(null == id){
			logger.error("Invalid accounr id......");
			throw new AccountIncorrectInputException();
		}
		return repositoryAccount.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
	}
	
	// All accounts

	public List<Account> allAccounts() {
		List<Account> lst = repositoryAccount.findAll();
		if (null == lst || lst.isEmpty()) {
			logger.error("Accounts do not exist in system ");
			throw new AccountNotFoundException();
		}
		return  lst;
	}

	// Edit account nickname

	public Account editAccountNickName(Account newAccount) {
		
		if(null == newAccount || null == newAccount.getId() || null == newAccount.getAccountNickName()
				|| newAccount.getAccountNickName().isEmpty()){
			logger.error("Invalid input......");
			throw new AccountIncorrectInputException();
		}

		Long id = newAccount.getId();
		Optional<Account> optaccount = repositoryAccount.findById(id);
		Account account = optaccount.orElseThrow(() -> new AccountNotFoundException(id));
		optaccount.map(ac -> {
			ac.setAccountNickName(newAccount.getAccountNickName());
			Account acc = repositoryAccount.save(ac);
			if (null == acc){
				throw new AccountNotFoundException();
			}
			return acc;
		}).orElseGet(() -> {
			return repositoryAccount.save(newAccount);
		});
		return account;
	}

	// Create new account

	public Account newAccount(Account newAccount) {
		if(null == newAccount || null == newAccount.getProfileId()){
			logger.error("Invalid input......");
			throw new AccountIncorrectInputException();
		}
		Long profileId = newAccount.getProfileId();
		repositoryAccountProfile.findById(profileId).orElseThrow(() -> new AccountProfileNotFoundException(profileId));		
		return repositoryAccount.save(newAccount);
	}

}
