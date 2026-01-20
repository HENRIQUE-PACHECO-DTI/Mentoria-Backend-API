package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.resources;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.PersonOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.PersonNotFoundException;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para expor os recursos de Person
 * @author Henrique Pacheco
 * @version 1.0.1
 */


@Slf4j
@Tag(name = "Person", description = "Recursos/Endpoints para gerenciamento de Pessoas")
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private  final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @Operation(summary = "Criar Pessoa", description = "Endpoint para criação de uma nova Entidade Pessoa e persistir no banco de dados.")
    @ApiResponse(responseCode = "201", description = "Pessoa criada com sucesso.")
    @ApiResponse(responseCode = "400", description = "Requisição inválida ao criar Pessoa.")
    public ResponseEntity<?> createPerson(@RequestBody PersonInputDTO personInputDTO){
       try{
           var person =  personService.createPerson(personInputDTO);
           log.info(">>createPerson Person Criada com sucesso!: " + person);
           return ResponseEntity.status(HttpStatus.CREATED).body(person);
       }catch (CreatePersonException e){
           log.warn(">>createPerson Erro ao realizar a criação da Person: " + HttpStatus.BAD_REQUEST + "Erro: " + e.getMessage());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter Pessoa por ID", description = "Endpoint para obter uma Entidade Pessoa pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Pessoa obtida com sucesso.")
    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada para o ID")
    public ResponseEntity<?> getPersonbyId(@PathVariable String id){
        try{
            var person = personService.getPersonById(id);
            return ResponseEntity.status(HttpStatus.OK).body(person);
        } catch (PersonNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "Obter todas as Pessoas", description = "Endpoint para obter todas as Entidades Pessoa ou filtrar por termo.")
    @ApiResponse(responseCode = "200", description = "Pessoas obtidas com sucesso.")
    @ApiResponse(responseCode = "200", description = "Pessoa com o termo especificado obtida com sucesso.")
    public ResponseEntity<List<PersonOutputDTO>> getPersons(
            @RequestParam(name = "t", required = false) String termo) {

        if (termo == null || termo.isBlank()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(personService.getAllPerson());
        }

        List<PersonOutputDTO> filtered = personService.getAllByTerm(termo);
        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @GetMapping("/contagemPessoas")
    @Operation(summary = "Contagem de Pessoas", description = "Endpoint para obter a contagem total de Pessoas cadastradas no banco.")
    @ApiResponse(responseCode = "200", description = "Contagem obtida com sucesso.")
    public ResponseEntity<Integer> contagemPessoas(){
        var contagem = personService.contagemPessoas();
        return ResponseEntity.status(HttpStatus.OK).body(contagem);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Pessoa", description = "Endpoint para atualizar uma Entidade Pessoa existente pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso.")
    public ResponseEntity<PersonOutputDTO> atualizarPerson(@RequestBody PersonInputDTO personInputDTO, @PathVariable String id){

        PersonOutputDTO personAtualizada = personService.atualizarPerson(personInputDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(personAtualizada);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar Item da Pessoa", description = "Endpoint para atualizar um item específico de uma Entidade Pessoa existente pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Item da Pessoa atualizado com sucesso.")
    public ResponseEntity<PersonOutputDTO> atualizarItemPerson(@RequestBody PersonInputDTO personInputDTO, @PathVariable String id){

        PersonOutputDTO personAtualizada = personService.atualizarItemPerson(id, personInputDTO);
        return ResponseEntity.status(HttpStatus.OK).body(personAtualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Pessoa", description = "Endpoint para deletar uma Entidade Pessoa existente pelo seu ID.")
    @ApiResponse(responseCode = "204", description = "Pessoa deletada com sucesso.")
    public ResponseEntity<Void> deletarPerson(@PathVariable String id){
        personService.deletarPerson(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
