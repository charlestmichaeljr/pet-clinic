package com.charlie.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
