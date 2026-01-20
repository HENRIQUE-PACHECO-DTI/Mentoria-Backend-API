package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output;


import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;



/**
 * @author Henrique Pacheco
 * Outgoing DTO to Person Entity
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "PersonOutputDTO",description = "Dados de uma pessoa retornados pela API.")
public class PersonOutputDTO {

    @Schema(
            description = "Identificador único do cliente",
            example = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
    )
    private String id;
    @Schema(example = "Aguiar", description = "Sobrenome da pessoa.")
    private String surName;
    @Schema(example = "Henrique", description = "Nome da pessoa.")
    private String name;
    @Schema( example = "1995-08-15", description = "Data de nascimento da pessoa.")
    private String bornDate;
    @Schema(example = "[\"Java\",\"Spring Boot\",\"Docker\"]", description = "Lista de tecnologias que a pessoa domina.")
    private List<String> stack;

    @Override
    public String toString() {
        return "PersonOutputDTO{" +
                "id='" + id + '\'' +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", stack=" + stack +
                '}';
    }
}

