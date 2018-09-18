package com.charlie.petclinic.repositories;

import com.charlie.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet,Integer> {
}
