package com.manage.people.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PersonDto {
    @NotBlank
    @Size(min = 2, max = 250)
    private String name;
    @NotNull
    private String birthDate;
    private List<AdressDto> adress;


}
