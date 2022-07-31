package com.alkemy.disney.services.Implement;

import com.alkemy.disney.models.Gender;
import com.alkemy.disney.models.GenderFilm;
import com.alkemy.disney.repositories.GenderFilmRepository;
import com.alkemy.disney.repositories.GenderRepository;
import com.alkemy.disney.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    GenderFilmRepository genderFilmRepository;

    @Override
    public List<Gender> getListGender(Set<Long> setGender) {
        return genderRepository.findAllById(setGender);
    }

    @Override
    public Gender getGender(long id) {
        return genderRepository.findById(id).orElse(null);
    }

    @Override
    public void saveGender(Gender gender) {
        genderRepository.save(gender);}


}
