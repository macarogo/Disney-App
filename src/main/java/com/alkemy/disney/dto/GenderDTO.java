package com.alkemy.disney.dto;


import com.alkemy.disney.models.Gender;
import com.alkemy.disney.models.GenderFilm;


import java.util.Set;
import java.util.stream.Collectors;

public class GenderDTO {

    private long id;

    private String name;

    private String images;

    private Set<String> genderFilms;

    public GenderDTO() {
    }

    public GenderDTO(Gender gender){

        this.id = gender.getId();
        this.name = gender.getName();
        this.images = gender.getImages();
        this.genderFilms = gender.getGenderFilms().stream().map(genderFilm -> genderFilm.getFilm().getTitle()).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImages() {
        return images;
    }

    public Set<String> getGenderFilms() {
        return genderFilms;
    }
}
