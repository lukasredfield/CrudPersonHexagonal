package com.raven.personapp.application.mapper;

import com.raven.personapp.application.model.request.PersonRequest;
import com.raven.personapp.application.model.response.PersonResponse;
import com.raven.personapp.domain.model.PersonModel;
import com.raven.personapp.infrastructure.entity.PersonEntity;
import com.raven.personapp.infrastructure.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonRestMapper {

    PersonRestMapper INSTANCE = Mappers.getMapper(PersonRestMapper.class);    //PARA QUÉ O POR QUÉ NECESITO TRANSFORMAR EL "PersonModel" a "PersonRequest" o "PersonResponse"?

    PersonModel toPersonModel(PersonRequest personRequest);

    PersonResponse toPersonResponse(PersonModel personModel);

    List<PersonModel> mapToPersonListResponse(List<PersonModel> personModelList);

}
