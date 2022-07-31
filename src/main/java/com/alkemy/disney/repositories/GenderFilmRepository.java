package com.alkemy.disney.repositories;

import com.alkemy.disney.models.GenderFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GenderFilmRepository extends JpaRepository<GenderFilm, Long> {
}
