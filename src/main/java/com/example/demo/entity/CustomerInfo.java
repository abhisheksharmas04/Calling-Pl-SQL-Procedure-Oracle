package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "customer_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomerInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer customerId;
	
	@Column(length = 20)
	@NonNull
	private String custName;
	
	@Column(length = 20)
	@NonNull
	private String custAddress;
	
	@NonNull
	private LocalDateTime dob;
	
	@NonNull
	private LocalTime timeOfPurchase;
	
	@NonNull
	private LocalDate dop;
}
