package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.service.IVaccineManagementService;

public class ApplicationRunner implements CommandLineRunner{
	
	@Autowired
	private IVaccineManagementService service;

	@Override
	public void run(String... args) throws Exception {
		
	}

}
