package com.bp.javaonboard.osm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.javaonboard.osm.entity.Account;
import com.bp.javaonboard.osm.entity.Order;

import com.bp.javaonboard.osm.service.IOrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/osm")
public class OSMController {
	
	@Autowired
	IOrderService iOrderService;
    
    @PutMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
    	return iOrderService.createAccount(account);
    }
    
    @GetMapping("/getAccount/{accountId}")
    public Optional<Account> getAccount(@PathVariable String accountId) {   	
         return iOrderService.getAccount(accountId);
    }
    
    @PostMapping("/updateAccount")
    public void updateAccount(@RequestBody Account account) {
    	iOrderService.updateAccount(account);
    }
    
    @DeleteMapping("/deleteAccountById/{accountId}")
    public void deleteAccount(@PathVariable String accountId) {
    	iOrderService.deleteAccount(accountId);
    }
    
    @GetMapping("/getAccounts")
    public List<Account> getAccounts() {   	
         return iOrderService.getAccounts();
    }
    
    @PutMapping("/createOrder")
    public void createOrder(@RequestBody Order order) {
    	iOrderService.createOrder(order);
    }
    
    @GetMapping("/getOrder/{orderId}")
    public Optional<Order> getOrder(@PathVariable String orderId) {
        return iOrderService.getOrderByOrderId(orderId);	
    }
    
    
    @GetMapping("/getOrders/{orderId}")
    public List<Order> getOrders() {
        return iOrderService.getOrders();	
    }
    
  
   

}
