package com.alkemy.disney.services;

import com.alkemy.disney.models.MainCharacterFilm;

import java.util.List;

public interface MainCharacterFilmService {

    List<MainCharacterFilm> getCharacterFilm();

    void saveCharacterFilm(MainCharacterFilm mainCharacterFilm);

    void deleteCharacterFilm(MainCharacterFilm mainCharacterFilm);
}
