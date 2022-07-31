package com.alkemy.disney.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class GenderFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gender_id")
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="filmGender_id")
    private Film film;

    public GenderFilm(Gender gender1, Gender gender2, Gender gender3, Film film1) {
    }

    public GenderFilm(Gender gender, Film film) {
        this.gender = gender;
        this.film = film;
    }

    public long getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
