package com.raven.personapp.infrastructure.mapper;

import com.raven.personapp.domain.model.PersonModel;
import com.raven.personapp.infrastructure.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);  //QUE ESTA PASANDO ACÁ? ¿Esta creando creando una propiedad o una instancia de uotra interfaz? o es una clase?

    PersonModel toPersonModel(PersonEntity personEntity);

    PersonEntity toPersonEntity(PersonModel personModel);

    List<PersonModel> mapToPersonListModel(List<PersonEntity> personEntityList);   //Para qué crea este método o para que sirve?

}
