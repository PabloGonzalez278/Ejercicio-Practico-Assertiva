package com.contratistas.contratistascsv.servicios;
import com.contratistas.contratistascsv.model.CSVContratistas;
import com.contratistas.contratistascsv.model.Contratistas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContratistaTransformer {
    private static final Logger log = LoggerFactory.getLogger(ContratistaTransformer.class);

    private final CorreoCorporativo correoCorporativo;
    //Constructor
    public ContratistaTransformer(CorreoCorporativo correoCorporativo) {
        this.correoCorporativo = correoCorporativo;
    }

    public List<CSVContratistas> transform(List<Contratistas> usuarios, String dominio){
        List<CSVContratistas> filas = new ArrayList<>();
        int index =0;
        for(Contratistas usuario : usuarios){
            index++;
            try{
                String nombre = seguro(usuario.nombre());
                if(nombre.isEmpty()){
                    throw new IllegalArgumentException("El Nombre no esta completo.");
                }
                filas.add(new CSVContratistas(
                        nombre,
                        seguro(usuario.telefono()),
                        seguro(usuario.correo()),
                        seguro(usuario.empresa() != null ? usuario.empresa().nombre() : null),
                        seguro(usuario.direccion() != null ? usuario.direccion().ciudad() : null),
                        correoCorporativo.Siguiente_Correo_Corporativo(nombre,dominio)
                ));
            } catch (Exception ex) {
                log.warn("Registro {} omitido por validacion: {}",index,ex.getMessage());
            }
        }

        return filas;
    }

    String seguro(String valor){
        return valor == null ? "" : valor.trim();
    }
}
