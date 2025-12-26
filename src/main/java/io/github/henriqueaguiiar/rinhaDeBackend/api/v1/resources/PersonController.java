package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.resources;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.PersonOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private  final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/api/v1/person")
    public ResponseEntity<PersonOutputDTO> createPerson(@RequestBody PersonInputDTO personInputDTO){
       var person =  personService.createPerson(personInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

}
