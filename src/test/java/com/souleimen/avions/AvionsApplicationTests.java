package com.souleimen.avions;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.repos.AvionRepository;
import com.souleimen.avions.service.AvionService;

@SpringBootTest
class AvionsApplicationTests {

	@Autowired
	private AvionRepository AvionRepository;
	
	@Autowired
	private AvionService avionService;
	
	@Test
	public void testCreateAvion() {
	Avion avio = new Avion("boeing123",300000,new Date());
	AvionRepository.save(avio);
	}
	
	@Test
	public void testFindAvion()
	{
	Avion a = AvionRepository.findById(1L).get(); 
	System.out.println(a);
	}
	
	
	@Test
	public void testUpdateAvion()
	{
	Avion a = AvionRepository.findById(1L).get();
	a.setCelometrageAvion(100000);
	AvionRepository.save(a);
	}

	@Test
	public void testDeleteAvion()
	{
		AvionRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousAvions()
	{
	List<Avion> avios = AvionRepository.findAll();
	for (Avion a : avios)
	{
	System.out.println(a);
	}
	}
	
	 @Test
	 public void testFindByNomAvionContains()
	 {
	 Page<Avion> avios = avionService.getAllAvionsParPage(0,2);
	 System.out.println(avios.getSize());
	 System.out.println(avios.getTotalElements());
	 System.out.println(avios.getTotalPages());
	 avios.getContent().forEach(a -> {System.out.println(a.toString());
	  });
	 /*ou bien
	 for (Avion a : avios.getContent())
	 {
	 System.out.println(a);
	 } */
	 }
}
