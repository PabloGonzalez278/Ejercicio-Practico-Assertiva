package com.contratistas.contratistascsv.servicios;

import com.contratistas.contratistascsv.model.CSVContratistas;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ExportCSV {

        public void export (List<CSVContratistas> filas, Path outputPath) throws IOException {
            if(filas.isEmpty()){
                throw new IllegalStateException("No hay filas validas para generar el archivo CSV");
            }
            if(outputPath.getParent()!= null){
                Files.createDirectories(outputPath.getParent());
            }
            try (BufferedWriter writer = Files.newBufferedWriter(outputPath)){
            writer.write("Nombre Completo, Telefono,Correo Electronico,Empresa,Ciudad,Correo Corportativo generado");
            writer.newLine();
            for(CSVContratistas fila : filas){
                    writer.write(csvfila(fila.Nombre())+ ","
                            + csvfila(fila.Telefono())+ ","
                            + csvfila(fila.Email())
                            + csvfila(fila.Empresa())+ ","
                            + csvfila(fila.Ciudad())+ ","
                            + csvfila(fila.Email_corporativo())+ ","

                )
            }

            }

        }
    private String csvfila(String valor){
            String safe = valor == null ? "": valor.trim();
            return "\"" + safe.replace("\"", "\"\"") + "\"";

    }
}

