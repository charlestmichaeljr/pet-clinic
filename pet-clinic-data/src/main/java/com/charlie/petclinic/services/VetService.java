package com.charlie.petclinic.services;

import com.charlie.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Integer id);
    Vet save(Vet Vet);
    Set<Vet> findAll();
}
