package io.github.henriqueaguiiar.rinhaDeBackend.domain.service;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.PersonOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service responsavel por realizar as operações dos endpoints de Person. Evitando Expor Repository
 * @author Henrique Pacheco
 * @version 1.0.0
 */

@Service
public interface PersonService {

     PersonOutputDTO createPerson (PersonInputDTO personInputDTO);

     PersonOutputDTO getPersonById(String id);

     List<PersonOutputDTO> getAllPerson();

     List<PersonOutputDTO> getAllByTerm(String term);

    void validateInputPerson(PersonInputDTO personInputDTO);

    Integer contagemPessoas();

    PersonOutputDTO atualizarPerson(PersonInputDTO personInputDTO, String id);

    PersonOutputDTO atualizarItemPerson(String id, PersonInputDTO personInputDTO);

    void deletarPerson(String id);

}
