package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MarrigeSeeker;
import com.example.demo.repo.IMarrigeSeekerRepo;

@Service("matrimonyService")
public class MatrimonyServiceImp implements IMatrimonyServiceManagement {
	
	@Autowired
	private IMarrigeSeekerRepo msRepo;

	@Override
	public String registerMarriageSeeker(MarrigeSeeker seeker) {
		return "Marriage sekker info is saved with id values: " + msRepo.save(seeker).getId();
	}

}
