package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerInfo;
import com.example.demo.repo.CustomerRepo;

@Service("customerService")
public class CustomerServiceImp implements ICustomerManagementService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public String registerCustomer(CustomerInfo cust) {
		int idVal = custRepo.save(cust).getCustomerId();
		return "Customer is saved with Id: " + idVal;
	}

	@Override
	public List<CustomerInfo> getAllCustomer() {
		return custRepo.findAll();
	}

}
