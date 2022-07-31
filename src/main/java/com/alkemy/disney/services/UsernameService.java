package com.alkemy.disney.services;

import com.alkemy.disney.models.Username;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UsernameService {

    List<Username> getListUsername();

    Username getUser(long id);

    void saveUser(Username username);

    Username getUsernameByEmail(String email);


}
