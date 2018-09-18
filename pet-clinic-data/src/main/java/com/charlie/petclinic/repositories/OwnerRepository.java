package com.charlie.petclinic.repositories;

import com.charlie.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Integer> {
    Owner findByLastName(String lastName);
}
