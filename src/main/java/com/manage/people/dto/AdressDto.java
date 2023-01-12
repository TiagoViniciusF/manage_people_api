package com.manage.people.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AdressDto {
    @NotNull
    @Size(min = 3, max = 150)
    private String logradouro;
    @NotNull
    private String cep;
    @NotNull
    @Size(min =1, max = 8)
    private String numero;
    @NotNull
    @Size(min = 2, max= 150)
    private String cidade;

}
