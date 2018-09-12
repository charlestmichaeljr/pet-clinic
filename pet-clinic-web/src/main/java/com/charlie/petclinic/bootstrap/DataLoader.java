package com.charlie.petclinic.bootstrap;

import com.charlie.petclinic.model.Owner;
import com.charlie.petclinic.model.Pet;
import com.charlie.petclinic.model.PetType;
import com.charlie.petclinic.model.Vet;
import com.charlie.petclinic.services.OwnerService;
import com.charlie.petclinic.services.PetTypeService;
import com.charlie.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("1600 Pennsylvania Avenue");
        owner1.setCity("Washington");
        owner1.setTelephone("999-304-1256");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bill");
        owner2.setLastName("Clinton");
        owner2.setAddress("2234 Bubba St.");
        owner2.setCity("Fayetteville");
        owner2.setTelephone("210-555-4908");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Pet barkley = new Pet();
        barkley.setPetType(savedDogPetType);
        barkley.setBirthDate(LocalDate.now());
        barkley.setOwner(owner1);
        barkley.setName("Barkley");
        owner1.getPets().add(barkley);

        ownerService.save(owner1);

        Pet sassy = new Pet();
        sassy.setPetType(savedDogPetType);
        sassy.setBirthDate(LocalDate.now());
        sassy.setOwner(owner2);
        sassy.setName("Sassy");
        owner2.getPets().add(sassy);

        ownerService.save(owner2);

        System.out.println("Dogs loaded");

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
