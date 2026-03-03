package com.contratistas.contratistascsv.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties(
        String endpoint,
        String fallbackJson,
        String outputCsv,
        String domain
) {}