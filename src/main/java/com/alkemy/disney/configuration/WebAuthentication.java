package com.alkemy.disney.configuration;

import com.alkemy.disney.models.Username;
import com.alkemy.disney.repositories.UsernameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UsernameRepository usernameRepository;


    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(inputName-> {

            Username username= usernameRepository.findByEmail(inputName);

            if (username != null) {

                if (username.getEmail().equals("admin@mindhub.com")) {

                    return new User(username.getEmail(), username.getPassword(),

                            AuthorityUtils.createAuthorityList("ADMIN"));
                } else {

                    return  new User(username.getEmail(), username.getPassword(),
                            AuthorityUtils.createAuthorityList("CLIENT"));
                }

            } else {

                throw new UsernameNotFoundException("Unknown user: " + inputName);

            }

        });

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }


}
