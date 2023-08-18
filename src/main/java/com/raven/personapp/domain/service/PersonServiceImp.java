package com.raven.personapp.domain.service;

import com.raven.personapp.domain.exception.BusinessException;
import com.raven.personapp.domain.exception.PersonNotFoundException;
import com.raven.personapp.domain.model.PersonModel;
import com.raven.personapp.domain.port.PersonPersistencePort;
import com.raven.personapp.domain.port.PersonServicePort;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class PersonServiceImp implements PersonServicePort {

    private final PersonPersistencePort personPersistencePort;

//    public PersonServiceImp(PersonPersistencePort personPersistencePort){            ESTO ES LO QUE HACE LA ANNOTATION "@RequiredArgsConstructor" EN LAS SOMBRAS
//        this.personPersistencePort = personPersistencePort;                          Lo que hace este annotation es crearte un constructor que acepte solo campos "final" y "Not Null"
//    }                                                                                PERO PARA QUE NECESITO SI O SI QUE SEA "final Y NOT NULL"??

    @Override
    public PersonModel addPerson(PersonModel personModel) {                           // Estos métodos para que sirven? Estan inicializando otros métodos nomás?
        return this.personPersistencePort.addPerson(personModel);
    }

    @Override
    public PersonModel updatePerson(PersonModel personModel, Long id) {
        return this.personPersistencePort.updatePerson(personModel,id);
    }

    @Override
    public void deletePerson(Long id) throws BusinessException{                       //QUE ESTA SUCESIENDO EN ESTE BLOQUE DE CÓDIGO?  ¿"Optional.ofNullable"? ¿"existPerson.orElseThrow"? ¿Exceptions???
        Optional<PersonModel> existPerson = Optional.ofNullable(this.personPersistencePort.getById(id));
        this.personPersistencePort.deletePerson(existPerson.orElseThrow(PersonNotFoundException::new).getId());
    }

    @Override
    public List<PersonModel> getAllPersons() {
        return this.personPersistencePort.getAllPersons();
    }

    @Override                                                              //QUE ESTA SUCESIENDO EN ESTE BLOQUE DE CÓDIGO?  ¿"Optional.ofNullable"? ¿"existPerson.orElseThrow"? ¿Exceptions???
    public PersonModel getById(Long id) throws BusinessException {
        Optional<PersonModel> existPerson = Optional.ofNullable(this.personPersistencePort.getById(id));
        return existPerson.orElseThrow(PersonNotFoundException::new);
    }
}
