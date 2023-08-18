package com.raven.personapp.domain.port;

import com.raven.personapp.domain.exception.BusinessException;
import com.raven.personapp.domain.model.PersonModel;

import java.util.List;

/**
 * Estos servicios son para consumir desde la capa de application, podemos usar las funcionalidades desde allí
 */

public interface PersonServicePort {

    PersonModel addPerson(PersonModel personModel);

    PersonModel updatePerson(PersonModel personModel, Long id);

    void deletePerson(Long id) throws BusinessException;

    List<PersonModel> getAllPersons();

    PersonModel getById(Long id) throws BusinessException;

}
