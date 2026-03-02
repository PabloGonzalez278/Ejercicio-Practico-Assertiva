package com.contratistas.contratistascsv.servicios;
import org.springframework.stereotype.Service;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

@Service
public class CorreoCorporativo {
    private final Map<String, Integer> Contadorusuario = new HashMap<>();

    public String Siguiente_Correo_Corporativo(String Nombre, String Dominio) {
        String usuarioBase = UsuarioCorporativo(Nombre);
        int contador = Contadorusuario.getOrDefault(usuarioBase, 0);
        Contadorusuario.put(usuarioBase, contador + 1);
        String usuario = contador == 0 ? usuarioBase: usuarioBase + contador;
        return usuario + "@" + Dominio;
    }

    public String UsuarioCorporativo(String Nombre) {
            String Normalizado = Normalizer.normalize(Nombre, Normalizer.Form.NFD).replaceAll("\\p{M}", "")
                    .replaceAll("[^a-zA-Z\\s'-]", " ")
                    .trim()
                    .replaceAll("\\s+", " ");

            String[] partes =Normalizado.split(" ");
            if(partes.length < 2) {
                throw new IllegalArgumentException("El nombre no es valido para crear el correo Corporativo" + Nombre);
            }
            String inicial = partes[0].substring(0,1).toLowerCase();
            String apellido = partes[partes.length-1]
                    .replace("'","")
                    .replace("-","")
                    .toLowerCase();
            return inicial + apellido;
    }

}
