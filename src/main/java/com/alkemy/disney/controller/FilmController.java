package com.alkemy.disney.controller;

import com.alkemy.disney.dto.FilmDTO;

import com.alkemy.disney.models.*;
import com.alkemy.disney.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private MainCharacterService mainCharacterService;

    @Autowired
    private MainCharacterFilmService mainCharacterFilmService;

    @Autowired
    private GenderFilmService genderFilmService;



    @GetMapping("/listFilms")
    public List<FilmDTO> getListFilms(){return filmService.getFilmDTO();}

    //Add Film
    @PostMapping("/addFilm")
    public ResponseEntity<Object> createNewFilm(@RequestParam String images, @RequestParam String title, @RequestParam @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate releaseDate,
                                                @RequestParam Integer qualification, @RequestParam Set<Long> idsMainCharacters, @RequestParam Set<Long> idGender){


        List<MainCharacter> characters = mainCharacterService.getSetMainCharacter(idsMainCharacters);
        List<Gender> getListGender = genderService.getListGender(idGender);

        Film newFilm = new Film(images, title, releaseDate, qualification);
        filmService.saveFilm(newFilm);

        List<GenderFilm> relationshipGenderFilm = getListGender.stream().map(gender -> new GenderFilm(gender,newFilm)).collect(Collectors.toList());
        relationshipGenderFilm.forEach(genderFilm -> genderFilmService.saveGenderFilm(genderFilm));

        List<MainCharacterFilm> relationshipCharacterFilm = characters.stream().map(mainCharacter -> new MainCharacterFilm(mainCharacter, newFilm)).collect(Collectors.toList());
        relationshipCharacterFilm.forEach(mainCharacterFilm -> mainCharacterFilmService.saveCharacterFilm(mainCharacterFilm));

        return new ResponseEntity<>("New Film", HttpStatus.CREATED);
    }

    //Modify Film
    @PatchMapping("modifyFilm")
    public ResponseEntity<Object> modifyFilm (@PathVariable Long id, @RequestParam String images, @RequestParam String title, @RequestParam @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate releaseDate,
                                              @RequestParam Integer qualification){

        Film film = filmService.getFilm(id);

        film.setImages(images);
        film.setTitle(title);
        film.setReleaseDate(releaseDate);
        film.setQualification(qualification);

        return new ResponseEntity<>("Modify Film", HttpStatus.ACCEPTED);
    }

    //Delete Film
    @DeleteMapping("/deleteFilm")
    public ResponseEntity<Object> deleteFilm (@PathVariable Long id){

        Film film = filmService.getFilm(id);
        film.getMainCharacterFilms().forEach(mainCharacterFilm -> mainCharacterFilmService.deleteCharacterFilm(mainCharacterFilm));
        filmService.deleteFilm(film);

        return new ResponseEntity<>("Delete Film", HttpStatus.ACCEPTED);
    }

    //Name film search
    @GetMapping(params = "name")
    public List<FilmDTO> searchNameFilm (@RequestParam String name){

        if (name.isEmpty()){
            return filmService.getFilmDTO();
        }

        return filmService.getFilmDTO().stream().filter(filmDTO -> filmDTO.getTitle().equals(name)).collect(Collectors.toList());
    }

    //Gender film search
    @GetMapping(params = "genre")
    public List<FilmDTO> searchGenderFilm (@RequestParam Long idGender){

        Gender genders = genderService.getGender(idGender);

        if (genders == null){
            return filmService.getFilmDTO();
        }

        List<GenderFilm> getGenderFilm = genders.getGenderFilms().stream().filter(genderFilm -> genderFilm.getGender().equals(genders)).collect(Collectors.toList());
        List<Film> getFilm = getGenderFilm.stream().map(genderFilm -> genderFilm.getFilm()).collect(Collectors.toList());

        return getFilm.stream().map(film -> new FilmDTO(film)).collect(Collectors.toList());

    }

    //Add Character Film
    @PostMapping("/{movies}/characters/{idCharacter}")
    public ResponseEntity<Object> addCharacterFilm (@PathVariable Long idFilm, @PathVariable Long idCharacter){

        MainCharacter getMainCharacter = mainCharacterService.getMainCharacter(idCharacter);
        Film getFilm = filmService.getFilm(idFilm);

        MainCharacterFilm newRelationship = new MainCharacterFilm(getMainCharacter, getFilm);
        mainCharacterFilmService.saveCharacterFilm(newRelationship);

        return new ResponseEntity<>("Modify Chacter Film", HttpStatus.ACCEPTED);
    }

    //Delete Character Film
    @DeleteMapping("/movies/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Object> deleteCharacterFilm (@PathVariable Long idFilm, @PathVariable Long idCharacter){

        Film film = filmService.getFilm(idFilm);

        if (film == null){
            return new ResponseEntity<>("film no fount", HttpStatus.FORBIDDEN);
        }

        Set<MainCharacterFilm> setCharacterFilm = film.getMainCharacterFilms();
        Set<MainCharacterFilm> relationship = setCharacterFilm.stream().filter(mainCharacterFilm -> mainCharacterFilm.getCharacter().getId() == idCharacter).collect(Collectors.toSet());
        relationship.forEach(mainCharacterFilm -> mainCharacterFilmService.deleteCharacterFilm(mainCharacterFilm));


        return new ResponseEntity<>("Delete Character Film", HttpStatus.ACCEPTED);
    }


    //Ascending or descending form

}
