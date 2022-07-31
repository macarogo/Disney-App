package com.alkemy.disney.services.Implement;

import com.alkemy.disney.models.MainCharacterFilm;
import com.alkemy.disney.repositories.MainCharacterFilmRepository;
import com.alkemy.disney.services.MainCharacterFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCharacterFilmServiceImpl implements MainCharacterFilmService {

    @Autowired
    MainCharacterFilmRepository mainCharacterFilmRepository;

    @Override
    public List<MainCharacterFilm> getCharacterFilm() {
        return mainCharacterFilmRepository.findAll();
    }

    @Override
    public void saveCharacterFilm(MainCharacterFilm mainCharacterFilm) {
        mainCharacterFilmRepository.save(mainCharacterFilm);
    }

    @Override
    public void deleteCharacterFilm(MainCharacterFilm mainCharacterFilm) {
        mainCharacterFilmRepository.delete(mainCharacterFilm);
    }

}
