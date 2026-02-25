package com.ejercicio.Contratistas;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosUsuario(
        public record
                String Nombre,
        String Correo,
        String Telefono,
        Direccion direccion,
        Empresa empresa
){
    @JsonIgnoreProperties (ignoreUnknown = true)
    public record Direccion(String ciudad){

    }
    @JsonIgnoreProperties (ignoreUnknown = true)
    public record Empresa(String nombre){

    }
}