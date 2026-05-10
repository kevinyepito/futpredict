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

import com.futpredict.backend.entity.Jugador;
import com.futpredict.backend.service.JugadorService;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost" })
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<Jugador> getJugadores() {
        return jugadorService.getAll();
    }

    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable Long id) {
        return jugadorService.getById(id);
    }

    @PostMapping
    public Jugador saveJugador(@RequestBody Jugador jugador) {
        return jugadorService.save(jugador);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorService.delete(id);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        return jugadorService.update(id, jugador);
    }

}
