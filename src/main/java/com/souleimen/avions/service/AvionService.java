package com.souleimen.avions.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.souleimen.avions.entities.Avion;

public interface AvionService {
Avion saveAvion(Avion a);
Avion updateAvion(Avion a);
void deleteAvion(Avion a);
void deleteAvionById(Long id);
Avion getAvion(Long id);
List<Avion> getAllAvions();

Page<Avion> getAllAvionsParPage(int page, int size);

}