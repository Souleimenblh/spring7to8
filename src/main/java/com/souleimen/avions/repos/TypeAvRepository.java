package com.souleimen.avions.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.souleimen.avions.entities.TypeAv;
public interface TypeAvRepository extends JpaRepository<TypeAv, Long> 
{
}
