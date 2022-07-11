package com.example.demo.service;

public interface IVaccineManagementService {
	public String authenticate(String user, String password);
	public Object[] getEmpDetailsByEno(int eno);

}