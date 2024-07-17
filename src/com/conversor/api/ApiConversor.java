package com.conversor.api;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ApiConversor {
    private static final String BASE_API_URL = "https://v6.exchangerate-api.com/v6/3c4e08905d13eb766810cb6c/pair/";

    public static double obtenerTasaCambio(String siglaOrigen, String siglaDestino, double cantidad) throws Exception {
        String apiUrl = BASE_API_URL + URLEncoder.encode(siglaOrigen, StandardCharsets.UTF_8) + "/" + URLEncoder.encode(siglaDestino, StandardCharsets.UTF_8) + "/" + cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        return jsonObject.get("conversion_result").getAsDouble();
    }
}
