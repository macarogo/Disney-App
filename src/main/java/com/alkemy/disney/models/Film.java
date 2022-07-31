package com.alkemy.disney.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String images;

    private String title;

    private LocalDate releaseDate;

    private Integer qualification;


    @OneToMany(mappedBy="film", fetch= FetchType.EAGER)
    private Set<MainCharacterFilm> mainCharacterFilms = new HashSet<>();

    @OneToMany(mappedBy="film", fetch= FetchType.EAGER)
    private List<GenderFilm> genderFilms  = new ArrayList<>();

    public Film() {
    }

    public Film(String images, String title, LocalDate releaseDate, Integer qualification) {
        this.images = images;
        this.title = title;
        this.releaseDate = releaseDate;
        this.qualification = qualification;
    }

    public long getId() {
        return id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public Set<MainCharacterFilm> getMainCharacterFilms() {
        return mainCharacterFilms;
    }

    public void setMainCharacterFilms(Set<MainCharacterFilm> mainCharacterFilms) {
        this.mainCharacterFilms = mainCharacterFilms;
    }

    public List<GenderFilm> getGenderFilms() {
        return genderFilms;
    }

    public void setGenderFilms(List<GenderFilm> genderFilms) {
        this.genderFilms = genderFilms;
    }
}
