package com.bp.javaonboard.osm;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bp.javaonboard.osm.entity.Account;
import com.bp.javaonboard.osm.repository.AccountRepository;
import com.bp.javaonboard.osm.service.impl.OrderService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OsmApplicationTests {
	
	@Autowired
	OrderService orderService;
	
	@MockBean
	AccountRepository accountRepository;

	@Test
	public void getAccountsTest() {
		
		when(accountRepository.findAll())
				              .thenReturn(Stream.of(new Account("2", "WifiAccount", "COM", "A", null),
				            		    new Account("3","OtherAccount", "RES", "A", null))
				              .collect(Collectors.toList()));
		assertEquals(2, orderService.getAccounts().size());
				            
	}
	
	@Test
	public void getAccountTest() {
		String accountId = "4";
		
		when(accountRepository.findById(accountId))
		.thenReturn(Optional.of((new Account("4","VideoAccount","RES","A", null))));
		
	}
	

	@Test
	public void createAccountTest() {
		Account account = new Account("7","NewAccount","RES","A", null);
		when(accountRepository.save(account)).thenReturn(account);
		assertEquals(account, orderService.createAccount(account));
	}
	
	@Test
	public void deleteAccountTest() {
		Optional<Account> account = Optional.of(new Account("7","NewAccount","RES","A", null));		
		when(accountRepository.findById("7")).thenReturn(account);
		orderService.deleteAccount(account.get().getAccountId());
		verify(accountRepository, times(1)).deleteById(account.get().getAccountId());
	}

}
