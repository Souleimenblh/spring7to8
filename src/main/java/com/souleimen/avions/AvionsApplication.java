package com.souleimen.avions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.service.AvionService;

@SpringBootApplication
public class AvionsApplication implements CommandLineRunner {

	@Autowired
	AvionService avionService;
	
	public static void main(String[] args) {
		SpringApplication.run(AvionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
		avionService.saveAvion(new Avion("Boeing233", 2600, new Date()));
		avionService.saveAvion(new Avion("Airline231", 2800, new Date()));
		avionService.saveAvion(new Avion("Skyflight242", 900, new Date()));
		}
	
}
