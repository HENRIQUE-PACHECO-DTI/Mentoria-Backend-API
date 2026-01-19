package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output;

import com.github.f4b6a3.uuid.UuidCreator;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Person;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


/**
 * @author Henrique Pacheco
 * Outgoing DTO to Person Entity
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDTO {


    private String id;
    private String surName;
    private String name;
    private String bornDate;
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

