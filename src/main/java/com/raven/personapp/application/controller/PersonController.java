package com.raven.personapp.application.controller;

import com.raven.personapp.application.mapper.PersonRestMapper;
import com.raven.personapp.application.model.request.PersonRequest;
import com.raven.personapp.application.model.response.PersonResponse;
import com.raven.personapp.domain.model.PersonModel;
import com.raven.personapp.domain.port.PersonServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServicePort personServicePort;

    //@PostMapping("/add")
    public ResponseEntity<PersonResponse> addPerson(@RequestBody PersonRequest personRequest){
        PersonModel personModel = PersonRestMapper.INSTANCE.toPersonModel(personRequest);
        PersonResponse personResponse = PersonRestMapper.INSTANCE.toPersonResponse(
                this.personServicePort.addPerson(personModel)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
    }

}
