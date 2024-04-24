package com.souleimen.avions.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.repos.AvionRepository;

@Service
public class AvionServiceImpl implements AvionService {

	@Autowired
	AvionRepository avionRepository;

	@Override
	public Avion saveAvion(Avion a) {
		return avionRepository.save(a);
	}

	@Override
	public Avion updateAvion(Avion a) {
		return avionRepository.save(a);

	}

	@Override
	public void deleteAvion(Avion a) {
		avionRepository.delete(a);
	}

	@Override
	public void deleteAvionById(Long id) {
		avionRepository.deleteById(id);
		
	}

	@Override
	public Avion getAvion(Long id) {
		return avionRepository.findById(id).get();

	}

	@Override
	public List<Avion> getAllAvions() {
		return avionRepository.findAll();
	}

	@Override
	public Page<Avion> getAllAvionsParPage(int page, int size) {
		return avionRepository.findAll(PageRequest.of(page, size));

	}

}
