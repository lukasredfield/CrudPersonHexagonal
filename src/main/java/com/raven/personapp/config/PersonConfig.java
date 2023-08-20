package com.raven.personapp.config;

import com.raven.personapp.domain.port.PersonPersistencePort;
import com.raven.personapp.domain.port.PersonServicePort;
import com.raven.personapp.domain.service.PersonServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean
    public PersonServicePort personService(PersonPersistencePort personPersistencePort){
        return new PersonServiceImp(personPersistencePort);
    }
}
