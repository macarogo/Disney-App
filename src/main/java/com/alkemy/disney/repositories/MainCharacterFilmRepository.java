package com.alkemy.disney.repositories;

import com.alkemy.disney.models.MainCharacterFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MainCharacterFilmRepository extends JpaRepository<MainCharacterFilm, Long> {
}
