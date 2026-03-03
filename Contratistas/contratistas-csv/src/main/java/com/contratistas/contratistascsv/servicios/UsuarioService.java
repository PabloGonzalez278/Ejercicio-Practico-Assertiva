package com.contratistas.contratistascsv.servicios;
import com.contratistas.contratistascsv.config.AppConfig;
import com.contratistas.contratistascsv.config.AppProperties;
import com.contratistas.contratistascsv.model.Contratistas;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final AppProperties appProperties;

    public UsuarioService(RestTemplateBuilder restTemplateBuilder,
                          ObjectMapper objectMapper,
                          AppProperties appProperties) {

        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(10))
                .setReadTimeout(Duration.ofSeconds(15))
                .build();

        this.objectMapper = objectMapper;
        this.appProperties = appProperties;
    }

    public List<Contratistas> getUsuarios() throws IOException {

        try {

            log.info("Consulta de endpoint remoto iniciado: {}", appProperties.endpoint());

            ResponseEntity<Contratistas[]> respuesta =
                    restTemplate.getForEntity(appProperties.endpoint(), Contratistas[].class);

            Contratistas[] body = respuesta.getBody();

            if (!respuesta.getStatusCode().is2xxSuccessful() || body == null) {
                throw new IllegalStateException("Respuesta inválida del endpoint");
            }

            return List.of(body);

        } catch (RestClientException ex) {

            log.warn("No es posible consumir el endpoint remoto. Se usará fallback local. Motivo: {}",
                    ex.getMessage());

            String json = Files.readString(Path.of(appProperties.Json()));

            return objectMapper.readValue(
                    json,
                    new TypeReference<List<Contratistas>>() {}
            );
        }
    }
}
