package com.bp.javaonboard.osm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bp.javaonboard.osm.entity.Account;
import com.bp.javaonboard.osm.entity.Order;

@Service
public interface IOrderService {

	void createOrder(Order order);

	Account createAccount(Account account);

	Optional<Account> getAccount(String accountId);
	List<Account> getAccounts();

	Optional<Order> getOrderByOrderId(String orderId);
	List<Order> getOrders();

	void updateAccount(Account account);

	void deleteAccount(String accountId);

}
