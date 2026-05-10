package com.futpredict.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futpredict.backend.entity.Liga;
import com.futpredict.backend.service.LigaService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/ligas")
@CrossOrigin(origins =  {"http://localhost:5173", "http://localhost" })
public class LigaController {

    private final LigaService ligaService;

    public LigaController(LigaService ligaService) {
        this.ligaService = ligaService;
    }

    @GetMapping
    public List<Liga> getLigas() {
        return ligaService.getAll();
    }

    @GetMapping("/{id}")
    public Liga getLigaById(@PathVariable Long id) {
        return ligaService.getById(id);
    }

    @PostMapping
    public Liga saveLiga(@RequestBody Liga liga) {
        return ligaService.save(liga);
    }

    @DeleteMapping("/{id}")
    public void deleteLiga(@PathVariable Long id) {
        ligaService.delete(id);
    }

    @PutMapping("/{id}")
    public Liga updateLiga(@PathVariable Long id, @RequestBody Liga liga ) {
            
        return ligaService.update(id, liga);
    }

}
