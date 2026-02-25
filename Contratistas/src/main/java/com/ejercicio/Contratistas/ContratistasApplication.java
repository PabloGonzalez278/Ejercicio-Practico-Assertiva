package com.ejercicio.Contratistas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Imports
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ContratistasApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ContratistasApplication.class, args);
	}

	private static final Logger log =LoggerFactory.getLogger(ContratistasApplication.class);
	private static final String Dominio ="democompany.com";

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	@Value("${app.endpoint:https://https://jsonplaceholder.typicode.com/users}")
	private String endpoint;

	@Value ("${app.output.csv:datacsv/Contratistas.csv}")
	private String archivoCSV;

	@Value ("${app.fallback-json:datacsv/Contratistas.json}")
	private String archivoJson;

	public ContratistasApplication(RestTemplateBuilder rest TemplateBuilder, ObjetyMapper objectMapper) {
		
	}

}
