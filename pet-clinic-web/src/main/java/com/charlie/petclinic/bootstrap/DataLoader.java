package com.charlie.petclinic.bootstrap;

import com.charlie.petclinic.model.Owner;
import com.charlie.petclinic.model.Vet;
import com.charlie.petclinic.services.OwnerService;
import com.charlie.petclinic.services.VetService;
import com.charlie.petclinic.services.map.OwnerServiceMap;
import com.charlie.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1);
        owner1.setFirstName("Barack");
        owner1.setLastName("Obama");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2);
        owner2.setFirstName("Bill");
        owner2.setLastName("Clinton");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1);
        vet1.setFirstName("Steve");
        vet1.setLastName("Irwin");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2);
        vet2.setFirstName("Marlon");
        vet2.setLastName("Perkins");

        vetService.save(vet2);

        System.out.println("Loaded vets");

    }
}
