package com.charlie.petclinic.repositories;

import com.charlie.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty,Integer> {
}
