package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CoronaVaccine;

public interface IVaccineManagementService {
	public List<CoronaVaccine>searchVaccineByPriceRange(double min, double max);

}
