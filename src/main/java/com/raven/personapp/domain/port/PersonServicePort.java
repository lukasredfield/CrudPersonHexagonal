package com.raven.personapp.domain.port;

import com.raven.personapp.application.model.response.PersonResponse;
import com.raven.personapp.domain.exception.BusinessException;
import com.raven.personapp.domain.model.PersonModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Estos servicios son para consumir desde la capa de application, podemos usar las funcionalidades desde allí
 */


public interface PersonServicePort {

    PersonModel addPerson(PersonModel personModel);

    PersonModel updatePerson(PersonModel personModel);

    void deletePerson(Long id) throws BusinessException;

    List<PersonModel> getAllPersons();

    PersonModel getById(Long id) throws BusinessException;

}
