package com.contratistas.contratistascsv.model;

public record CSVContratistas(
        String nombre,
        String telefono,
        String correo,
        String empresa,
        String ciudad,
        String correoCorporativo
) {
}
