package com.alkemy.disney.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MainCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String url;

    private String name;

    private int age;

    private String weight;

    private String history;

    @OneToMany(mappedBy= "mainCharacter", fetch= FetchType.EAGER)
    private Set<MainCharacterFilm> mainCharacterFilms = new HashSet<>();


    public MainCharacter() {
    }

    public MainCharacter(String url, String name, int age, String weight, String history) {
        this.url = url;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Set<MainCharacterFilm> getMainCharacterFilms() {
        return mainCharacterFilms;
    }

    public void setMainCharacterFilms(Set<MainCharacterFilm> mainCharacterFilms) {
        this.mainCharacterFilms = mainCharacterFilms;
    }
}
