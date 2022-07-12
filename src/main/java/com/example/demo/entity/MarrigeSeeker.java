package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "marrige_seeker")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MarrigeSeeker implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	@Column(length = 20)
	private String name;
	
	@NonNull
	@Column(length = 20)
	private String address;
	
	@NonNull
	@Lob
	private byte[] photo;
	
	@NonNull
	@Lob
	private char[] biodata;
	
	@NonNull
	private LocalDateTime dob;
	
	@NonNull
	private Boolean indian;
	

}
