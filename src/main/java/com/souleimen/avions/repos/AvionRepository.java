package com.souleimen.avions.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souleimen.avions.entities.Avion;

public interface AvionRepository extends JpaRepository<Avion, Long> {

}
