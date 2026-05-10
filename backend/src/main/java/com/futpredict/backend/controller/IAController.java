package com.futpredict.backend.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futpredict.backend.service.IAService;

@RestController
@RequestMapping("/api/ia")
@CrossOrigin(origins = { "http://localhost:5173", "http://localhost" })
public class IAController {
    private final IAService iaService;

    public IAController(IAService iaService) {
        this.iaService = iaService;
    }

    @PostMapping("/predecir")
    public Map<String, Object> predeMap(@RequestBody Map<String, Object> datos) {

        return iaService.predecir(datos);
    }
}
