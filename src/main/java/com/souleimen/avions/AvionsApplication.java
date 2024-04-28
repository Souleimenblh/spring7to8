package com.souleimen.avions;

//import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.souleimen.avions.entities.Avion;
//import com.souleimen.avions.service.AvionService;

@SpringBootApplication
public class AvionsApplication implements CommandLineRunner {
/*
	@Autowired
	AvionService avionService;
*/
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(AvionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
		/*
		avionService.saveAvion(new Avion("Boeing233", 5422600, new Date()));
		avionService.saveAvion(new Avion("Airline231", 212800, new Date()));
		avionService.saveAvion(new Avion("Skyflight242", 1119900, new Date()));
		*/
	
		repositoryRestConfiguration.exposeIdsFor(Avion.class);

}
}