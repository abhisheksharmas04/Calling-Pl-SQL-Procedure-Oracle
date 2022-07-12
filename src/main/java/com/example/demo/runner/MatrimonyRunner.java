package com.example.demo.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.entity.MarrigeSeeker;
import com.example.demo.service.IMatrimonyServiceManagement;

public class MatrimonyRunner implements CommandLineRunner{
	
	@Autowired
	private IMatrimonyServiceManagement service;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Person Name: ");
		String name = "Abhishek";
		
		System.out.println("Enter Person Address: ");
		String address = "Jaipur";
		
		System.out.println("Enter Person Photo Complete Path: ");
		String photoPath = "C:\\Users\\DeLL\\Desktop\\rd.jpg";		
		
		System.out.println("Enter Person Bio Data Path: ");
		String bioDataPath = "C:\\Users\\DeLL\\Desktop\\recoverylink.txt";
		
		System.out.println("Is the Person is Indian?");
		Boolean indian = true;
		
		// prepare byte array representing photo file content
		InputStream is = new FileInputStream(photoPath);
		byte[] photoContent = new byte[is.available()];
		photoContent = is.readAllBytes();
		
		// preapare character array to representing bio data file content
		File file = new File(bioDataPath);
		Reader reader = new FileReader(file);
		char[] bioDataContent = new char[(int)file.length()];
		reader.read(bioDataContent);
		
		//preapare entity class object		
		MarrigeSeeker seeker = new MarrigeSeeker(name,address,photoContent,bioDataContent,
				LocalDateTime.of(1990,11,23,12,45),indian);
		
		System.out.println(service.registerMarriageSeeker(seeker));
		
	}

}
