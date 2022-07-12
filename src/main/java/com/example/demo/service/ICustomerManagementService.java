package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CustomerInfo;

public interface ICustomerManagementService {
	
	public String registerCustomer(CustomerInfo cust);
	public List<CustomerInfo>getAllCustomer();

}
