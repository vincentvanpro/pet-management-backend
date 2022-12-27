package com.company.petmanagementbackend.repository;

import com.company.petmanagementbackend.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findPetById(Long id);
}
