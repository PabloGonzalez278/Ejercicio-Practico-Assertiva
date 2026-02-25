package com.contratistas.contratistascsv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
    public record Contratistas(
            String Nombre,
            String Correo,
            String Telefono,
            Direccion direccion,
            Empresa empresa
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Direccion(String ciudad) {

        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Empresa(String nombre) {

        }
    }

