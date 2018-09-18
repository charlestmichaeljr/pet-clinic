package com.charlie.petclinic.services.map;

import com.charlie.petclinic.model.Specialty;
import com.charlie.petclinic.model.Vet;
import com.charlie.petclinic.services.CrudService;
import com.charlie.petclinic.services.SpecialtyService;
import com.charlie.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet,Integer> implements VetService {
    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findById(Integer id) {
        return super.findyById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }
}
