package com.charlie.petclinic.bootstrap;

import com.charlie.petclinic.model.Owner;
import com.charlie.petclinic.model.PetType;
import com.charlie.petclinic.model.Vet;
import com.charlie.petclinic.services.OwnerService;
import com.charlie.petclinic.services.PetTypeService;
import com.charlie.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        System.out.println("dog type id " + savedDogPetType.getId());

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("cat type id " + savedCatPetType.getId());

        System.out.println("Loaded Pet Types");

        Owner owner1 = new Owner();
        owner1.setFirstName("Barack");
        owner1.setLastName("Obama");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bill");
        owner2.setLastName("Clinton");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Steve");
        vet1.setLastName("Irwin");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marlon");
        vet2.setLastName("Perkins");

        vetService.save(vet2);

        System.out.println("Loaded vets");

    }
}
