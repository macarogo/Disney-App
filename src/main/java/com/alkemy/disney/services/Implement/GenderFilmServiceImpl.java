package com.alkemy.disney.services.Implement;

import com.alkemy.disney.models.GenderFilm;
import com.alkemy.disney.repositories.GenderFilmRepository;
import com.alkemy.disney.services.GenderFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GenderFilmServiceImpl implements GenderFilmService {


    @Autowired
    GenderFilmRepository genderFilmRepository;

    @Override
    public List<GenderFilm> getGenderFilm (Set<Long> setGender) {
        return genderFilmRepository.findAllById(setGender);
    }

    @Override
    public void saveGenderFilm(GenderFilm genderFilm) {
        genderFilmRepository.save(genderFilm);
    }

}
