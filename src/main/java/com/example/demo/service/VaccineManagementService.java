package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CoronaVaccine;

@Service
public class VaccineManagementService implements IVaccineManagementService{
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<CoronaVaccine> searchVaccineByPriceRange(double min, double max) {
		
		// create store procedure object representing our PL/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_VACCINE_BY_PRICERANGE", CoronaVaccine.class);
		
		//register Paramters of Store Producedure
		query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,CoronaVaccine.class,ParameterMode.REF_CURSOR);
		
		//set values to paramters
		query.setParameter(1,min);
		query.setParameter(2,max);
		
		// call pl/sql procedure
		List<CoronaVaccine> list = query.getResultList();
		return list;
	}

}
