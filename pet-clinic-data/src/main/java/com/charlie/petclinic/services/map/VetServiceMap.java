package com.charlie.petclinic.services.map;

import com.charlie.petclinic.model.Vet;
import com.charlie.petclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet,Integer> implements CrudService<Vet,Integer> {
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
        return super.save(object.getId(),object);
    }
}
