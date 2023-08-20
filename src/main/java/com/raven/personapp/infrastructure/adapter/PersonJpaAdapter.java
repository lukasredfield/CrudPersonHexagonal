package com.raven.personapp.infrastructure.adapter;

import com.raven.personapp.domain.model.PersonModel;
import com.raven.personapp.domain.port.PersonPersistencePort;
import com.raven.personapp.infrastructure.entity.PersonEntity;
import com.raven.personapp.infrastructure.mapper.PersonMapper;
import com.raven.personapp.infrastructure.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * El adaptador es el punto de entrada desde el dominio para poder utilizar los servicios de persistencia
 * ¿QUE HACEN O DE QUE SE ENCARGAN CADA MÉTODO DE ESTA CLASE?
 */

@Service
@RequiredArgsConstructor
public class PersonJpaAdapter implements PersonPersistencePort {

    private final PersonRepository personRepository;

    @Override
    public PersonModel addPerson(PersonModel personModel) {               //QUÉ ES LO QUE HACE ESTE MÉTODO EXACTAMENTE?
        PersonEntity personEntity = PersonMapper.INSTANCE.toPersonEntity(personModel);  // QUÉ ESTA PASANDO EN ESTA LÍNEA DE CÓDIGO? "PersonMapper.INSTANCE.toPersonEntity(personModel)" PORQUE TIENE ESA CADENA DE LLAMADAS A MÉTODOS E INSTANCIAS?
        PersonEntity personSaved = this.personRepository.save(personEntity);   //Porque crea una variable "personSave"???
        return PersonMapper.INSTANCE.toPersonModel(personSaved);   //Cómo es que llama a un "interface"?? o instancia de interfaz??
    }

    //(HECHO POR MI) (NO FUNCIONA)    ESTUDIAR EL CASO
//    @Override
//    public PersonModel updatePerson(PersonModel personModel, Long id) {
//        PersonEntity personExist = PersonMapper.INSTANCE.toPersonEntity(this.getById(id));
//        PersonModel personModify = PersonMapper.INSTANCE.toPersonModel(personExist);
//        return this.addPerson(personModify);
//    }

    @Override
    public PersonModel updatePerson(PersonModel personModel) {
        return this.addPerson(personModel);
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
        Optional<PersonEntity> personEntity = this.personRepository.findById(id);
        return personEntity.map(PersonMapper.INSTANCE::toPersonModel)
                .orElse(null);
    }




}
