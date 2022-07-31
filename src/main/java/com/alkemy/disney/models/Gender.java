package com.alkemy.disney.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;

    private String images;

    @OneToMany(mappedBy="gender", fetch= FetchType.EAGER)
    private Set<GenderFilm> genderFilms = new HashSet<>();

    public Gender() {
    }

    public Gender(String name, String images) {
        this.name = name;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Set<GenderFilm> getGenderFilms() {
        return genderFilms;
    }

    public void setGenderFilms(Set<GenderFilm> genderFilms) {
        this.genderFilms = genderFilms;
    }
}
