package com.alkemy.disney.repositories;

import com.alkemy.disney.models.Username;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsernameRepository extends JpaRepository<Username, Long> {

    Username findByEmail(String email);
}
