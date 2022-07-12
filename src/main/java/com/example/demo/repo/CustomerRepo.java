package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerInfo;

public interface CustomerRepo extends JpaRepository<CustomerInfo, Integer> {

}
