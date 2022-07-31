package com.alkemy.disney.services.Implement;

import com.alkemy.disney.dto.FilmDTO;
import com.alkemy.disney.models.Film;
import com.alkemy.disney.repositories.FilmRepository;
import com.alkemy.disney.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmDTO> getFilmDTO() {
        return filmRepository.findAll().stream().map(film -> new FilmDTO(film)).collect(Collectors.toList());
    }

    @Override
    public void saveFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public Film getFilm(long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFilm(Film film) {
        filmRepository.delete(film);
    }


}
