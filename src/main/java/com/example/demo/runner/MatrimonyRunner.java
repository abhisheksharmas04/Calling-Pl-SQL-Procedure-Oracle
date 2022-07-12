package com.example.demo.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
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
		/*Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println(service.registerMarriageSeeker(seeker));*/
		
		Optional<MarrigeSeeker>opt = service.searchSeekerById(4L);
		if(opt.isPresent()) {
			MarrigeSeeker seeker = opt.get();
			System.out.println(seeker.getId() + "" + seeker.getName() + "" + seeker.getAddress() + "" + seeker.getIndian());
			OutputStream os = new FileOutputStream("reterive_photo.jpg");
			os.write(seeker.getPhoto());
			os.flush();
			
			Writer writer = new FileWriter("reterive_bio_data.txt");
			writer.write(seeker.getBiodata());
			writer.flush();
			
			os.close();
			writer.close();
		}else {
			System.out.println("Record not Found");
		}
		
	}
}
