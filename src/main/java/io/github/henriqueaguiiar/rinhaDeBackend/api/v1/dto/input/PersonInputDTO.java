package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author Henrique Pacheco
 * Input DTO to Person Entity
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInputDTO {

    private String surName;
    private String name;
    private String bornDate;
    private List<String> stack;

    @Override
    public String toString() {
        return "PersonInputDTO{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", stack=" + stack +
                '}';
    }
}
