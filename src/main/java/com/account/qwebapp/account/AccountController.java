package com.account.qwebapp.account;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.qwebapp.account.exception.AccountIncorrectInputException;

@RestController
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountImpl accountImpl;

	// Aggregate accounts for user with balance
	
	@RequestMapping(value = "/account/userid", method = RequestMethod.GET)
	@ResponseBody
	List<Account> allAccountsforUser(@RequestParam("userid") String userid) {
		
		if(null == userid || userid.trim().isEmpty()){
			logger.error("Invalid user id......");
			throw new AccountIncorrectInputException();
		}
		List<Account> lst = accountImpl.allAccountsforUser(userid);
		return lst;
	}

	// Aggregate all accounts - **Shall not be used as it will return bulk
	// records and shall be used with Pageable pageable

	@GetMapping("/account")
	List<Account> allAccounts() {
		return accountImpl.allAccounts();
	}	

	// Single account

	@RequestMapping(value = "/account/id", method = RequestMethod.GET)
	@ResponseBody
	Account findAccount(@RequestParam("id") Long id) {		
		return accountImpl.findAccount(id);
	}	

	// Edit account nickname

	@RequestMapping(value = "/account/edit/nickname", method = RequestMethod.PUT)
	@ResponseBody
	Account editAccountNickName(@RequestBody Account newAccount) {
		Account account  = accountImpl.editAccountNickName(newAccount);		
		return account;
	}
	
	//Create new account

	@PostMapping("/account/create")
	Account newAccount(@RequestBody Account newAccount) {
		return accountImpl.newAccount(newAccount);
	}

}
