package com.charlie.petclinic.services.map;

import com.charlie.petclinic.model.Pet;
import com.charlie.petclinic.services.CrudService;
import com.charlie.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet,Integer> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findById(Integer id) {
        return super.findyById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
