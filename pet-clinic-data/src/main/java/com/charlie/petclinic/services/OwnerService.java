package com.charlie.petclinic.services;

import com.charlie.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Integer id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
