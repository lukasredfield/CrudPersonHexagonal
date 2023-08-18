package com.raven.personapp.infrastructure.adapter;

import com.raven.personapp.domain.model.PersonModel;
import com.raven.personapp.domain.port.PersonPersistencePort;
import com.raven.personapp.infrastructure.entity.PersonEntity;
import com.raven.personapp.infrastructure.mapper.PersonMapper;
import com.raven.personapp.infrastructure.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * El adaptador es el punto de entrada desde el dominio para poder utilizar los servicios de persistencia
 * ¿QUE HACEN O DE QUE SE ENCARGAN CADA MÉTODO DE ESTA CLASE?
 */

@Service
@RequiredArgsConstructor
public class PersonJpaAdapter implements PersonPersistencePort {

    PersonRepository personRepository;

    @Override
    public PersonModel addPerson(PersonModel personModel) {               //QUÉ ES LO QUE HACE ESTE MÉTODO EXACTAMENTE?
        PersonEntity personEntity = PersonMapper.INSTANCE.toPersonEntity(personModel);  // QUÉ ESTA PASANDO EN ESTA LÍNEA DE CÓDIGO? "PersonMapper.INSTANCE.toPersonEntity(personModel)" PORQUE TIENE ESA CADENA DE LLAMADAS A MÉTODOS E INSTANCIAS?
        PersonEntity personSaved = this.personRepository.save(personEntity);   //Porque crea una variable "personSave"???
        return PersonMapper.INSTANCE.toPersonModel(personSaved);   //Cómo es que llama a un "interface"?? o instancia de interfaz??
    }

    @Override
    public PersonModel updatePerson(PersonModel personModel, Long id) {   //Por qué es tan simple este método???
        return this.addPerson(personModel) ;
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }

    @Override
    public List<PersonModel> getAllPersons() {
        return PersonMapper.INSTANCE.mapToPersonListModel(
                this.personRepository.findAll());
    }

    @Override
    public PersonModel getById(Long id) {
        return this.personRepository.findById(id)
                .map(PersonMapper.INSTANCE::toPersonModel)
                .orElse(null);
    }
}
