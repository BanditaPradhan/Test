package com.bp.javaonboard.osm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.javaonboard.osm.repository.AccountRepository;
import com.bp.javaonboard.osm.repository.OrderRepository;

import com.bp.javaonboard.osm.service.IOrderService;
import com.bp.javaonboard.osm.entity.Account;
import com.bp.javaonboard.osm.entity.Order;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
    OrderRepository orderRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@Override
	public void createOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public Account createAccount(Account account) {		
		return accountRepository.save(account);
	}


	@Override
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}
	
	@Override
	public Optional<Account> getAccount(String accountId) {
		return accountRepository.findById(accountId);
	}

	@Override
	public Optional<Order> getOrderByOrderId(String orderId) {
		return orderRepository.findById(orderId);
	}
	
	@Override
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}


	@Override
	public void updateAccount(Account account) {
		accountRepository.save(account);		
	}

	@Override
	public void deleteAccount(String accountId) {
		accountRepository.deleteById(accountId);		
	}

}
