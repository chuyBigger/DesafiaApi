package com.aluracursos.desafio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.zip.GZIPInputStream;
import java.util.stream.Collectors;

public class ConsumoApi {

    private static final String URL_BASE = "https://www.haloapi.com/metadata/h5/metadata/";
    private static final String API_KEY = "3bbe5deb9a494bb2bb7948fe3cc04ce8";

    public String obtenerDatos(String url) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + url))
                .header("Ocp-Apim-Subscription-Key", API_KEY)
                .header("Accept-Encoding", "gzip")  // pedimos gzip si está disponible
                .build();

        try {
            HttpResponse<InputStream> response = client
                    .send(request, HttpResponse.BodyHandlers.ofInputStream());

            InputStream responseStream = response.body();

            // Verificar si la respuesta está comprimida
            String encoding = response.headers()
                    .firstValue("Content-Encoding")
                    .orElse("");

            InputStream finalStream = encoding.equalsIgnoreCase("gzip")
                    ? new GZIPInputStream(responseStream)
                    : responseStream;

            // Convertir a String
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(finalStream))) {
                return reader.lines().collect(Collectors.joining());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consumir la API", e);
        }
    }
}
