package com.alkemy.disney.services;

import com.alkemy.disney.dto.MainCharacterDTO;
import com.alkemy.disney.models.MainCharacter;

import java.util.List;
import java.util.Set;

public interface MainCharacterService {

    List<MainCharacterDTO> getMainCharactersDto();

    MainCharacterDTO getMainCharacterDTO(long id);

    MainCharacter getMainCharacter(long id);

    List<MainCharacter> getSetMainCharacter(Set<Long> setCharacter);

    void saveMainCharacter(MainCharacter mainCharacter);

    void deleteCharacter(MainCharacter mainCharacter);

    MainCharacter getCharacterByName(String name);

}
