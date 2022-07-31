package com.alkemy.disney.services.Implement;

import com.alkemy.disney.models.Username;
import com.alkemy.disney.repositories.UsernameRepository;
import com.alkemy.disney.services.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsernameServiceImpl implements UsernameService {

    @Autowired
    UsernameRepository usernameRepository;


    @Override
    public List<Username> getListUsername() {
        return usernameRepository.findAll();
    }

    @Override
    public Username getUser(long id) {
        return usernameRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(Username username) {
        usernameRepository.save(username);
    }

    @Override
    public Username getUsernameByEmail(String email) {
        return usernameRepository.findByEmail(email);
    }


}
