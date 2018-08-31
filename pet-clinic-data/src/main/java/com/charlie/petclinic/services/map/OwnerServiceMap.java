package com.charlie.petclinic.services.map;

import com.charlie.petclinic.model.Owner;
import com.charlie.petclinic.services.CrudService;
import com.charlie.petclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Integer> implements CrudService<Owner,Integer> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Integer integer) {
        return super.findyById(integer);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }
}
