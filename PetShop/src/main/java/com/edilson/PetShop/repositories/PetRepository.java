package com.edilson.PetShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilson.PetShop.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
