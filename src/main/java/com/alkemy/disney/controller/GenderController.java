package com.alkemy.disney.controller;

import com.alkemy.disney.models.Gender;
import com.alkemy.disney.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderService genderService;


    @PostMapping(params = "/add")
    public ResponseEntity<Object> creationNewGender(@RequestParam String name, @RequestParam String images){

        if (name.isEmpty() || images.isEmpty()){
            return new ResponseEntity<>("Imcomplete", HttpStatus.FORBIDDEN);
        }

        Gender newGender = new Gender(name, images);
        genderService.saveGender(newGender);

        return new ResponseEntity<>("New gender", HttpStatus.CREATED);
    }
}
