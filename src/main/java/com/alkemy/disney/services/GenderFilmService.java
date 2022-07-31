package com.alkemy.disney.services;

import com.alkemy.disney.models.GenderFilm;

import java.util.List;
import java.util.Set;

public interface GenderFilmService {

    List<GenderFilm> getGenderFilm (Set<Long> setGender);

    void saveGenderFilm (GenderFilm genderFilm);
}
