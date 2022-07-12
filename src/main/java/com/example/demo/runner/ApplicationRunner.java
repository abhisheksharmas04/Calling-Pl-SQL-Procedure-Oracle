package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.service.IEmpManagementService;

public class ApplicationRunner implements CommandLineRunner{
	
	@Autowired
	private IEmpManagementService service;

	@Override
	public void run(String... args) throws Exception {
		service.searchEmpByDesg("CLERK","MANAGER").forEach(System.out::println);
	}

}

