package com.charlie.petclinic.services.map;

import com.charlie.petclinic.model.Owner;
import com.charlie.petclinic.model.Pet;
import com.charlie.petclinic.services.OwnerService;
import com.charlie.petclinic.services.PetService;
import com.charlie.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Integer> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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
        if(object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet->{
                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId()==null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else {
                        throw new RuntimeException("Pet type is required");
                    }

                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
        }
        else {
            return null;
        }
        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
