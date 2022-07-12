package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.MarrigeSeeker;

public interface IMatrimonyServiceManagement {
	public String registerMarriageSeeker(MarrigeSeeker seeker);
	public Optional<MarrigeSeeker>searchSeekerById(Long id);

}
