package com.alkemy.disney.dto;

import com.alkemy.disney.models.Film;
import com.alkemy.disney.models.MainCharacter;

import java.util.Set;
import java.util.stream.Collectors;


public class MainCharacterDTO {

    private long id;

    private String url;

    private String name;

    private int age;

    private String weight;

    private String history;

    private Set<String>film;


    public MainCharacterDTO() {
    }

    public MainCharacterDTO(MainCharacter mainCharacter){

        this.id = mainCharacter.getId();

        this.url = mainCharacter.getUrl();

        this.name = mainCharacter.getName();

        this.age = mainCharacter.getAge();

        this.weight = mainCharacter.getWeight();

        this.history = mainCharacter.getHistory();

        this.film = mainCharacter.getMainCharacterFilms().stream().map(mainCharacterFilm -> mainCharacterFilm.getFilm().getTitle()).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getHistory() {
        return history;
    }

    public Set<String> getFilm() {
        return film;
    }
}
