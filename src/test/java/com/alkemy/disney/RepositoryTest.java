package com.alkemy.disney;


import com.alkemy.disney.models.Gender;
import com.alkemy.disney.models.MainCharacter;
import com.alkemy.disney.models.Username;
import com.alkemy.disney.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringBootTest

@AutoConfigureTestDatabase(replace = NONE)

public class RepositoryTest {

    @Autowired
    private UsernameRepository usernameRepository;

    @Autowired
    private MainCharacterRepository mainCharacterRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private MainCharacterFilmRepository mainCharacterFilmRepository;

    @Autowired
    private GenderFilmRepository genderFilmRepository;


    @Test
    public void existUsername() {

        List<Username> usernames = usernameRepository.findAll();

        assertThat(usernames, is(not(empty())));
    }

    @Test
    public void existUsernameCarolina() {

        List<Username> usernames = usernameRepository.findAll();
        assertThat(usernames, hasItem(hasProperty("firstName", is("Carolina"))));

    }

    @Test
    public void existCharacter() {

        List<MainCharacter> mainCharacters = mainCharacterRepository.findAll();

        assertThat(mainCharacters, is(not(empty())));
    }

    @Test
    public void existCharacterIsabelaMadrigal() {

        List<MainCharacter> mainCharacters = mainCharacterRepository.findAll();
        assertThat(mainCharacters, hasItem(hasProperty("name", is("Isabela Madrigal"))));

    }

    @Test
    public void existGender() {

        List<Gender> genders = genderRepository.findAll();

        assertThat(genders, is(not(empty())));
    }

    @Test
    public void existGenderFancy() {

        List<Gender> genders = genderRepository.findAll();
        assertThat(genders, hasItem(hasProperty("name", is("Fancy"))));

    }

}