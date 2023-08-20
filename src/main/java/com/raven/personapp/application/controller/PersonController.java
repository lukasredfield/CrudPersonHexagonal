package com.raven.personapp.application.controller;

import com.raven.personapp.application.mapper.PersonRestMapper;
import com.raven.personapp.application.model.request.PersonRequest;
import com.raven.personapp.application.model.response.PersonResponse;
import com.raven.personapp.domain.exception.BusinessException;
import com.raven.personapp.domain.model.PersonModel;
import com.raven.personapp.domain.port.PersonServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServicePort personServicePort;

    @GetMapping("/saludo")
    public ResponseEntity<String> saludar() {
        String mensaje = "¡Hola, mundo!";
        return ResponseEntity.ok(mensaje); // Devuelve una respuesta con código 200 OK y el cuerpo "¡Hola, mundo!"
    }

    @PostMapping
    public ResponseEntity<PersonResponse> addPerson(@RequestBody PersonRequest personRequest){
        PersonModel personModel = PersonRestMapper.INSTANCE.toPersonModel(personRequest);
        PersonResponse personResponse = PersonRestMapper.INSTANCE.toPersonResponse(
                this.personServicePort.addPerson(personModel)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonResponse> deletePerson(@PathVariable Long id) throws BusinessException {
        this.personServicePort.deletePerson(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@RequestBody PersonRequest personRequest) {
        PersonModel personModel = PersonRestMapper.INSTANCE.toPersonModel(personRequest);
        PersonResponse personResponse = PersonRestMapper.INSTANCE.toPersonResponse(
                personServicePort.updatePerson(personModel));
        return ResponseEntity.ok(personResponse);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PersonModel>> getAllPerson(){
        return ResponseEntity.ok(PersonRestMapper.INSTANCE.mapToPersonListResponse(this.personServicePort.getAllPersons()));
    }

    //(HECHO POR MI) (NO FUNCIONA)    ESTUDIAR EL CASO
//    @GetMapping("get/{id}")
//    public ResponseEntity<PersonResponse> getById(Long id) throws BusinessException{
//        return ResponseEntity.ok(PersonRestMapper.INSTANCE.toPersonResponse(this.personServicePort.getById(id)));
//
//    }

    @GetMapping("get/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable long id) throws BusinessException {
        PersonResponse personResponse = PersonRestMapper.INSTANCE.toPersonResponse(personServicePort.getById(id));
        return ResponseEntity.ok(personResponse);

    }





}
