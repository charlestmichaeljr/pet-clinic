package com.charlie.petclinic.services;

import com.charlie.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Integer id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
