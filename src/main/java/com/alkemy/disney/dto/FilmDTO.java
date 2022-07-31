package com.alkemy.disney.dto;

import com.alkemy.disney.models.Film;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmDTO {

    private long id;

    private String images;

    private String title;

    private LocalDate releaseDate;

    private Integer qualification;


    private Set<String> mainCharacter;



    public FilmDTO () {
    }

    public FilmDTO(Film film){

        this.id = film.getId();

        this.images = film.getImages();

        this.title = film.getTitle();

        this.releaseDate = film.getReleaseDate();

        this.qualification = film.getQualification();

        this.mainCharacter = film.getMainCharacterFilms().stream().map(mainCharacterFilm -> mainCharacterFilm.getCharacter().getName()).collect(Collectors.toSet());
    }


    public long getId() {
        return id;
    }

    public String getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getQualification() {
        return qualification;
    }

    public Set<String> getMainCharacter() {
        return mainCharacter;
    }

}
