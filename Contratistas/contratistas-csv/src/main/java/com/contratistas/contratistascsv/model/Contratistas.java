package com.contratistas.contratistascsv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Contratistas(

        @JsonProperty("name")
        String nombre,

        @JsonProperty("email")
        String correo,

        @JsonProperty("phone")
        String telefono,

        @JsonProperty("address")
        Direccion direccion,

        @JsonProperty("company")
        Empresa empresa

) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Direccion(
            @JsonProperty("city")
            String ciudad
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Empresa(
            @JsonProperty("name")
            String nombre
    ) {
    }
}

