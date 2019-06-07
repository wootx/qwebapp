package com.account.qwebapp;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.qwebapp.account.Account;
import com.account.qwebapp.account.AccountImpl;
import com.account.qwebapp.account.exception.AccountIncorrectInputException;
import com.account.qwebapp.account.exception.AccountNotFoundException;



@RunWith(SpringRunner.class)
@SpringBootTest
public class QwebappApplicationTests {

	
	@Autowired
	private AccountImpl accountImpl;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test_allAccountsforUser()
	{
		List<Account> lst = accountImpl.allAccountsforUser("arnie11");
		Assert.assertNotNull(lst);
		Assert.assertTrue(lst.size() > 0);
		
	}
	
	@Test
	public void test_allAccounts()
	{
		List<Account> lst = accountImpl.allAccounts();
		Assert.assertNotNull(lst);
		Assert.assertTrue(lst.size() > 0);
	}

	@Test
	public void test_findAccount()
	{
		Account act = accountImpl.findAccount(1l);
		Assert.assertNotNull(act);
		Assert.assertEquals(1, act.getId().longValue());
	}
	
	@Test
	public void test_editAccountNickName()
	{
		Account newAccount = new Account();
		newAccount.setId(1l);
		newAccount.setAccountNickName("drake");
		Account act = accountImpl.editAccountNickName(newAccount);
		Assert.assertNotNull(act);
		Assert.assertEquals("drake", act.getAccountNickName());
	}
	
	/*@Test
	public void test_newAccount()
	{
		Account newAccount = new Account();
		newAccount.setAccountType("SAV");
		newAccount.setAccountNickName("darth");
		newAccount.setBalance(new BigDecimal(2365.89));
		newAccount.setCurrency("CAD");
		newAccount.setPreferredAccount(false);
		newAccount.setProfileId(1l);
		newAccount.setUserId("arnie11");
		Account act = accountImpl.newAccount(newAccount);
		Assert.assertNotNull(act);
		Assert.assertEquals("darth", act.getAccountNickName());
	}*/
	
	@Test(expected = AccountNotFoundException.class)
	public void test_allAccountsforUserException()
	{
		accountImpl.allAccountsforUser("arnie12");
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void test_findAccountExcpetion()
	{
		accountImpl.findAccount(4l);		
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void test_editAccountNickNameExcetion()
	{
		Account newAccount = new Account();
		newAccount.setId(3l);
		newAccount.setAccountNickName("drake");
		accountImpl.editAccountNickName(newAccount);
		
	}
	
	@Test(expected = AccountIncorrectInputException.class)
	public void test_editAccountNickNameIncorrectInputExcetion()
	{
		Account newAccount = new Account();
		newAccount.setId(null);
		newAccount.setAccountNickName("drake");
		accountImpl.editAccountNickName(newAccount);
		
	}
	
	

}
