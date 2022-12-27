package com.company.petmanagementbackend.service;

import com.company.petmanagementbackend.exception.PetNotFoundException;
import com.company.petmanagementbackend.model.Pet;
import com.company.petmanagementbackend.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet updatePet(Long id, Pet pet) {
        Pet existingPet = findPetById(id);

        existingPet.setName(pet.getName());
        existingPet.setCode(pet.getCode());
        existingPet.setType(pet.getType());
        existingPet.setFurColor(pet.getFurColor());
        existingPet.setCountry(pet.getCountry());

        return petRepository.save(existingPet);
    }

    public Pet findPetById(Long id) {
        return petRepository.findPetById(id).orElseThrow(
                () -> new PetNotFoundException(
                        String.format("%s %d %s", "Pet with ID", id, "was not found")
                )
        );
    }
}
