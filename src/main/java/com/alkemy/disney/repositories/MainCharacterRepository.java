package com.alkemy.disney.repositories;

import com.alkemy.disney.models.MainCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MainCharacterRepository extends JpaRepository<MainCharacter, Long> {

 MainCharacter findByName (String name);
}