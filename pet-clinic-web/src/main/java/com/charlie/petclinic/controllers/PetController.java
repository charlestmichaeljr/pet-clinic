package com.charlie.petclinic.controllers;

import com.charlie.petclinic.model.Pet;
import com.charlie.petclinic.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping({"","/"})
    public String getPets(Model model) {
        Set<Pet> pets = new HashSet<>();
        petService.findAll().forEach(pets::add);
        model.addAttribute("pets",pets);
        return "pets/index";
    }
}
