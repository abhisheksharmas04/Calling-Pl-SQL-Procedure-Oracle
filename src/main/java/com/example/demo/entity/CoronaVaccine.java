package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "CORONA_VACCINE_TAB") :- Optional if we want to take db table name same as entity class name.
public class CoronaVaccine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "regNo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;

	@Column(name = "name", length = 20)
	private String name;

	@Column(name = "company", length = 20)
	private String company;

	@Column(name = "country", length = 20)
	private String country;

	private Double price;

	private Integer requiredDosesCount;

}
