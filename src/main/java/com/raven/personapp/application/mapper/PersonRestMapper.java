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

/**
 * 1)
 *
 * La creación de una instancia dentro de la interfaz con el mismo nombre es
 * un patrón conocido como "Singleton pattern" y es una práctica relativamente común,
 * aunque puede generar confusión en algunos contextos. El propósito de esta instancia es proporcionar
 * una única instancia de la interfaz a través de la cual se pueden acceder a los métodos de la interfaz.
 *      La idea detrás de esta técnica es utilizar el patrón Singleton para crear una única instancia que
 * represente al mapper definido por la interfaz. Esta instancia única es accesible en to do el código y
 * es compartida por todas las partes de la aplicación que necesitan realizar mapeos.
 *      Sí, tienes razón en que las interfaces generalmente se consideran como "contratos" que especifican
 * métodos a ser implementados por las clases. Sin embargo, en este caso, se está utilizando una característica
 * de Java llamada "static initialization blocks" que permite inicializar variables estáticas dentro de la interfaz.
 * Aunque esta técnica puede funcionar, no es la forma más convencional de hacerlo y puede llevar a confusiones en
 * la lectura del código.
 *
 * 2)
 *
 * La instancia INSTANCE en este contexto es una convención para nombrar una instancia única de la interfaz.
 * En este caso, se utiliza el patrón Singleton para crear una única instancia de la interfaz PersonRestMapper.
 * Sí, es común utilizar mayúsculas para nombrar constantes.
 *  La instancia es estática porque se declara en el ámbito de la interfaz y se utiliza el patrón Singleton,
 *  lo que significa que se crea una sola instancia que es compartida por toda la aplicación. Se puede llamar desde
 *  cualquier parte del proyecto debido a su alcance estático. Las variables y métodos estáticos en Java se pueden
 *  acceder directamente a través del nombre de la clase sin necesidad de crear una instancia de la clase.
 *
 *
 * 3)
 *
 * Sí, Mappers es una clase. Puedes llamar a Mappers.getMapper() directamente porque es un método estático de la clase
 * Mappers, y los métodos estáticos se pueden invocar en la clase misma sin necesidad de crear una instancia.
 *      El método getMapper en MapStruct recibe como parámetro el tipo de la interfaz del mapper que deseas obtener.
 * Al pasar PersonRestMapper.class, le estás indicando que deseas obtener una instancia del mapper definido por la
 * interfaz PersonRestMapper.
 *      .class en Java se utiliza para obtener el objeto Class asociado a una clase o tipo. En este caso, PersonRestMapper.class se
 * utiliza para obtener el objeto Class que representa la interfaz PersonRestMapper.
 *
 *
 */