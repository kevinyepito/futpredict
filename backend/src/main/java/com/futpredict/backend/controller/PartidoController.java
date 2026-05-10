package com.futpredict.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futpredict.backend.entity.Partido;
import com.futpredict.backend.service.PartidoService;

@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost" })
public class PartidoController {
    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping
    public List<Partido> getPartidos() {
        return partidoService.getAll();
    }

    // buscar prediccion por id
    @GetMapping("/{id}")
    public Partido getPartidoById(@PathVariable Long id) {
        return partidoService.getById(id);
    }

    @PostMapping
    public Partido savePartido(@RequestBody Partido partido) {
        return partidoService.save(partido);
    }

    @DeleteMapping("/{id}")
    public void deletePartido(@PathVariable Long id) {
        partidoService.delete(id);
    }

    @PutMapping("/{id}")
    public Partido updatePartido(@PathVariable Long id, @RequestBody Partido partido) {
        return partidoService.update(id, partido);
    }

}
