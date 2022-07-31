package com.alkemy.disney.services;

import com.alkemy.disney.dto.FilmDTO;
import com.alkemy.disney.models.Film;

import java.util.List;

public interface FilmService {

    List<FilmDTO> getFilmDTO();

    void saveFilm (Film film);

    Film getFilm (long id);

    void deleteFilm (Film film);
}
