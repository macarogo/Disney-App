package com.alkemy.disney.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class MainCharacterFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="character_id")
    private MainCharacter mainCharacter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="filmMainCharacter_id")
    private Film film;

    public MainCharacterFilm(MainCharacter character1, MainCharacter character2, MainCharacter character3, Film film1) {
    }

    public MainCharacterFilm(MainCharacter mainCharacter, Film film) {
        this.mainCharacter = mainCharacter;
        this.film = film;
    }

    public long getId() {
        return id;
    }

    public MainCharacter getCharacter() {
        return mainCharacter;
    }

    public void setCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
