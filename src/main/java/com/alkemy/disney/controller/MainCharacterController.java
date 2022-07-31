package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MainCharacterDTO;

import com.alkemy.disney.models.*;
import com.alkemy.disney.services.FilmService;
import com.alkemy.disney.services.MainCharacterFilmService;
import com.alkemy.disney.services.MainCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/characters")
public class MainCharacterController {

    @Autowired
    private MainCharacterService mainCharacterService;

    @Autowired
    private MainCharacterFilmService mainCharacterFilmService;

    @Autowired
    private FilmService filmService;


    @GetMapping("/listCharacters")
    public List<MainCharacterDTO> getListCharacters(){return mainCharacterService.getMainCharactersDto();}

    @GetMapping("/{id}")
    public MainCharacterDTO getCharacterId(@PathVariable Long id){return mainCharacterService.getMainCharacterDTO(id);}


    //Add
    @PostMapping(path = "/add")
    public ResponseEntity<Object> creationNewCharacter(

            @RequestParam String url, @RequestParam String name, @RequestParam int age,

            @RequestParam String weight, @RequestParam String history){

        if (url.isEmpty() || name.isEmpty() || history.isEmpty()){
            return new ResponseEntity<>("Imcomplete", HttpStatus.FORBIDDEN);
        }

        MainCharacter newCharacter =  new MainCharacter(url, name, age, weight, history);
        mainCharacterService.saveMainCharacter(newCharacter);

        return new ResponseEntity<>("New character", HttpStatus.CREATED);
    }

    //Modify
    @PatchMapping(path = "/modify")
    public ResponseEntity<Object> modifyCharacter (@PathVariable long id, @RequestParam String url, @RequestParam String name,

                                                   @RequestParam int age, @RequestParam String weight, @RequestParam String history){

        MainCharacter mainCharacter = mainCharacterService.getMainCharacter(id);

        mainCharacter.setUrl(url);
        mainCharacter.setName(name);
        mainCharacter.setAge(age);
        mainCharacter.setWeight(weight);
        mainCharacter.setHistory(history);
        mainCharacterService.saveMainCharacter(mainCharacter);

       return new ResponseEntity<>("Modify character", HttpStatus.ACCEPTED);
    }

    //Delete
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCharacter(@RequestParam Long id){

        MainCharacter deleteCharacter = mainCharacterService.getMainCharacter(id);
        mainCharacterService.deleteCharacter(deleteCharacter);

        return new ResponseEntity<>("Delete character", HttpStatus.ACCEPTED);
    }

    //Name Character search
    @GetMapping(params = "name")
    public List<MainCharacterDTO> searchNameFilm (@RequestParam String name){

        if (name.isEmpty()){
            return mainCharacterService.getMainCharactersDto();
        }

        return mainCharacterService.getMainCharactersDto().stream().filter(mainCharacterDTO -> mainCharacterDTO.getName().equals(name)).collect(Collectors.toList());
    }

    //Age Character search
    @GetMapping(params = "age")
    public List<MainCharacterDTO> searchNameFilm (@RequestParam int age){

        if (age == 0){
            return mainCharacterService.getMainCharactersDto();
        }

        return mainCharacterService.getMainCharactersDto().stream().filter(mainCharacterDTO -> mainCharacterDTO.getAge() == age).collect(Collectors.toList());
    }

    //Character film search
    @GetMapping(params = "movies")
    public List<MainCharacterDTO> searchGenderFilm (@RequestParam Long idFilm){

        Film film = filmService.getFilm(idFilm);

        if (film == null){
            return mainCharacterService.getMainCharactersDto();
        }

        List<MainCharacterFilm> getCharacterFilm = film.getMainCharacterFilms().stream().filter(mainCharacterFilm -> mainCharacterFilm.getCharacter().equals(film)).collect(Collectors.toList());
        List<MainCharacter> getCharacter = getCharacterFilm.stream().map(mainCharacterFilm -> mainCharacterFilm.getCharacter()).collect(Collectors.toList());

        return getCharacter.stream().map(mainCharacter -> new MainCharacterDTO(mainCharacter)).collect(Collectors.toList());

    }


}
