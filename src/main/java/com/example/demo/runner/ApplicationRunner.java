package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.IVaccineManagementService;

@Component
public class ApplicationRunner implements CommandLineRunner{
	
	@Autowired
	private IVaccineManagementService service;

	@Override
	public void run(String... args) throws Exception {
		service.searchVaccineByPriceRange(400.0f, 900.0f).forEach(System.out::println);
	}

}
