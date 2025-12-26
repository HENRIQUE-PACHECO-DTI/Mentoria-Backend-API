package io.github.henriqueaguiiar.rinhaDeBackend.domain.service;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    public void create (PersonInputDTO personInputDTO);

}
