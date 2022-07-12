package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Emp;

public interface IEmpManagementService {
	List<Emp> searchEmpByDesg(String desg1, String desg2);
}