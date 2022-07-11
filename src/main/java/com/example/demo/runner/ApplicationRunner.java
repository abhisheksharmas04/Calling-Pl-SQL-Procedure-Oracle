package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.service.IVaccineManagementService;

public class ApplicationRunner implements CommandLineRunner{
	
	@Autowired
	private IVaccineManagementService service;

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(service.authenticate("raja", "rani"));
		Object result[] = service.getEmpDetailsByEno(101);
		System.out.println("Emp Name: " + result[1]);
		System.out.println("Emp Desg: " + result[2]);
		System.out.println("Emp Salary: " + result[3]);
		System.out.println("Emp Dept: " + result[4]);
	}

}