package com.futpredict.backend.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IAService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String IA_URL = "http://ia-service:8000";

    /*
     * por el momento con Map, hay que mejorarlo con dto
     * public class PrediccionDTO {
        * private double prob_local;
        * private double prob_empate;
        * private double prob_visitante;
     * }
     * acá se  vería así:
     * ResponseEntity<PrediccionDTO>
     */
    public Map<String, Object> predecir(Map<String, Object> datos) {
        // http header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // cuerpo de la petición http, httpEntity combina body(datos) headers y
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(datos, headers);

        // hacer petición POST
        ResponseEntity<Map> response = restTemplate.postForEntity(
                IA_URL + "/predecir",
                request,
                Map.class);

        return response.getBody();

    }

}
