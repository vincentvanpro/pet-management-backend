package com.company.petmanagementbackend.controller;

import com.company.petmanagementbackend.model.Pet;
import com.company.petmanagementbackend.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/pets/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.findPetById(id);
    }

    @PostMapping("/pets")
    public Pet addPet(@Valid @RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    @PutMapping("/pets/{id}")
    public Pet updatePet(@Valid @RequestBody Pet petDetails, @PathVariable Long id) {
        return petService.updatePet(id, petDetails);
    }

}
