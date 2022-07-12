package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Emp;

public class EmpManagementServiceImpl implements IEmpManagementService{
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Emp> searchEmpByDesg(String desg1, String desg2) {
		// Create Store Procedure object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("GET_EMP_DETAILS_BY_DESG",Emp.class);
		
		//register paramters
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		
		//set param values
		query.setParameter(1,desg1);
		query.setParameter(2,desg2);
		
		//call plsql and get values
		List<Emp>listEmps = query.getResultList();
		
		return listEmps;
	}

}
