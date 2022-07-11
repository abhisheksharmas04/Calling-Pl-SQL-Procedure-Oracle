package com.example.demo.service;

import java.sql.CallableStatement;
import java.sql.Types;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class VaccineManagementService implements IVaccineManagementService{
	
	@Autowired
	private EntityManager manager;

	@Override
	public String authenticate(String user, String password) {
		
		//create stored procedure query object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_AUTHENTICATION");
		
		//register parameters
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		
		//set paramter values
		query.setParameter(1,user);
		query.setParameter(2,password);
		
		// call the procedure
		query.execute();
		
		//gather result from out paramter
		String result = (String) query.getOutputParameterValue(3);
		
		return result;
	}

	@Override
	public Object[] getEmpDetailsByEno(int eno) {
		// unwrap session object:
		Session session = manager.unwrap(Session.class);
		
		//Write plan jdbc code to call pl/sql function
		Object obj[] = session.doReturningWork(conn -> {
			CallableStatement cs = conn.prepareCall("{?=call FX_GET_EMP_DETAILS(?,?,,?,?)}");
			//register out paramters
			cs.registerOutParameter(1,Types.INTEGER); // return param ?(1)
			cs.registerOutParameter(3, Types.VARCHAR); // return param ? (3)
			cs.registerOutParameter(4, Types.VARCHAR); // return param ? (4)
			cs.registerOutParameter(5, Types.FLOAT); // return param ? (5)
			
			// set value to in param
			cs.setInt(2, eno);
			
			// call plsql function;
			cs.execute();
			
			// gathers results from return, out params
			Object objs[] = new Object[4];
			objs[0] = cs.getInt(1);
			objs[1] = cs.getString(3);
			objs[2] = cs.getString(4);
			objs[3] = cs.getFloat(5);
			
			return objs;
		});
		
		return obj;
	}

}
