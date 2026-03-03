package com.contratistas.contratistascsv.runner;

import com.contratistas.contratistascsv.config.AppProperties;
import com.contratistas.contratistascsv.model.CSVContratistas;
import com.contratistas.contratistascsv.model.Contratistas;
import com.contratistas.contratistascsv.servicios.EmpresaTransformer;
import com.contratistas.contratistascsv.servicios.ExportCSV;
import com.contratistas.contratistascsv.servicios.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
public class Proceso implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Proceso.class);
    private final UsuarioService usuarioService;
    private final EmpresaTransformer empresaTransformer;
    private final ExportCSV exportCSV;
    private final AppProperties appProperties;

    public Proceso(UsuarioService usuarioService, EmpresaTransformer empresaTransformer, ExportCSV exportCSV, AppProperties appProperties ) {
        this.usuarioService = usuarioService;
        this.empresaTransformer = empresaTransformer;
        this.exportCSV = exportCSV;
        this.appProperties = appProperties;
    }
    @Override
    public void run(String... args){
        log.info("Inicio Proceso de generación de contratistas");
        try {
            List<Contratistas> usuarios = usuarioService.getUsuarios();
            log.info("Total de registro obtenidos desde el endpoint: {}", usuarios.size());
            List<CSVContratistas> filas = empresaTransformer.transform(usuarios,appProperties.dominio());
            log.info("Total de registros procesados correctamente: {}", filas.size());

           exportCSV.export(filas, Path.of(appProperties.archivoCSV()));
           log.info("Confirmación de generacion de archivo CSV: {}", appProperties.archivoCSV());
           log.info("Proceso Finalizado correctamente");
        }catch (Exception ex){
            log.error("Proceso finalizado con error: {}", ex.getMessage(),ex);
            //System.exit(1);
        }
    }
}
