package com.charlie.petclinic.bootstrap;

import com.charlie.petclinic.model.*;
import com.charlie.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        System.out.println("dog type id " + savedDogPetType.getId());

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("cat type id " + savedCatPetType.getId());

        System.out.println("Loaded Pet Types");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedSurgery = specialtyService.save(surgery);
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialties");

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

        Visit dogVisit1 = new Visit();
        dogVisit1.setDescription("Distemper Shot");
        dogVisit1.setPet(sassy);
        dogVisit1.setDate(LocalDate.now());

        visitService.save(dogVisit1);

        Visit dogVisit2 = new Visit();
        dogVisit2.setDescription("Heartworm treatment");
        dogVisit2.setPet(barkley);
        dogVisit2.setDate(LocalDate.now());

        visitService.save(dogVisit2);

        //sassy.getVisits().add(dogVisit1);

        //barkley.getVisits().add(dogVisit2);

        System.out.println("Visits loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Steve");
        vet1.setLastName("Irwin");
        vet1.getSpecialties().add(savedDentistry);
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marlon");
        vet2.setLastName("Perkins");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets");
    }
}
