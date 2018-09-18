package com.charlie.petclinic.services.springdatajpa;

import com.charlie.petclinic.model.Specialty;
import com.charlie.petclinic.repositories.SpecialtyRepository;
import com.charlie.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springjpadata")
public class SpecialtyJPAService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Integer integer) {
        return null;
    }

    @Override
    public Specialty save(Specialty object) {
        return null;
    }

    @Override
    public void delete(Specialty object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
