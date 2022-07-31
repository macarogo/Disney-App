package com.alkemy.disney.services;

import com.alkemy.disney.models.Gender;
import com.alkemy.disney.models.GenderFilm;

import java.util.List;
import java.util.Set;


public interface GenderService {


 List<Gender> getListGender(Set<Long> setGender);

 Gender getGender(long id);

 void saveGender(Gender gender);


}
