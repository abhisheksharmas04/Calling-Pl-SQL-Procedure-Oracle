package com.example.demo.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.entity.CustomerInfo;
import com.example.demo.service.ICustomerManagementService;

public class DateTimeRunner implements CommandLineRunner{
	
	@Autowired
	private ICustomerManagementService service;

	@Override
	public void run(String... args) throws Exception {
		CustomerInfo cust = new CustomerInfo("raja","hyd",
					LocalDateTime.of(1990,10,21,15,10,3),
					LocalTime.now(), LocalDate.now());
		
		System.out.println(service.registerCustomer(cust));
	}

}