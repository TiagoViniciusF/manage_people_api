package com.manage.people.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Adress implements Serializable {
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    public Adress(){};
   @JsonCreator
    public Adress(@JsonProperty(value = "logradouro") String logradouro,
                  @JsonProperty(value = "cep") String cep,
                  @JsonProperty(value = "numero") String numero,
                  @JsonProperty(value = "cidade") String cidade) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }
}
