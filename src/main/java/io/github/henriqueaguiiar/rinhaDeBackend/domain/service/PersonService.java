package io.github.henriqueaguiiar.rinhaDeBackend.domain.service;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.PersonOutputDTO;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

     PersonOutputDTO createPerson (PersonInputDTO personInputDTO);

    void validateInputPerson(PersonInputDTO personInputDTO);


}
