package com.contratistas.contratistascsv.model;

public record CSVContratistas(
        String Nombre,
        String Telefono,
        String Email_personal,
        String Empresa,
        String Ciudad,
        String Email_corporativo
) {
}
