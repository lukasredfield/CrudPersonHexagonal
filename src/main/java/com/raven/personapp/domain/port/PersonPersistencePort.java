package com.raven.personapp.domain.port;

import com.raven.personapp.domain.model.PersonModel;

import java.util.List;

/**
 * Esta ara exponer los servicios desde la capa de dominio a la capa de infrastructure
 */

public interface PersonPersistencePort {

    PersonModel addPerson(PersonModel personModel);

    PersonModel updatePerson(PersonModel personModel, Long id);

    void deletePerson(Long id);

    List<PersonModel> getAllPersons();

    PersonModel getById(Long id);

}
