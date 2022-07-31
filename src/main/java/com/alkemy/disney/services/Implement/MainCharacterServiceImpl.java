package com.alkemy.disney.services.Implement;

import com.alkemy.disney.dto.MainCharacterDTO;
import com.alkemy.disney.models.MainCharacter;
import com.alkemy.disney.repositories.MainCharacterRepository;
import com.alkemy.disney.services.MainCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MainCharacterServiceImpl implements MainCharacterService {

    @Autowired
    MainCharacterRepository mainCharacterRepository;


    @Override
    public List<MainCharacterDTO> getMainCharactersDto() {
        return mainCharacterRepository.findAll().stream().map(mainCharacter -> new MainCharacterDTO(mainCharacter)).collect(Collectors.toList());
    }

    @Override
    public MainCharacterDTO getMainCharacterDTO(long id) {
        return mainCharacterRepository.findById(id).map(mainCharacter -> new MainCharacterDTO(mainCharacter)).orElse(null);
    }

    @Override
    public MainCharacter getMainCharacter(long id) {
        return mainCharacterRepository.findById(id).orElse(null);
    }

    @Override
    public List<MainCharacter> getSetMainCharacter(Set<Long> setCharacter) {
        return mainCharacterRepository.findAllById(setCharacter);
    }

    @Override
    public void saveMainCharacter(MainCharacter mainCharacter) {
    mainCharacterRepository.save(mainCharacter);
    }

    @Override
    public void deleteCharacter(MainCharacter mainCharacter) {
        mainCharacterRepository.delete(mainCharacter);
    }

    @Override
    public MainCharacter getCharacterByName(String name) {
        return mainCharacterRepository.findByName(name);
    }


}
