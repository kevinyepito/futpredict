package com.futpredict.backend.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futpredict.backend.model.Equipo;
import com.futpredict.backend.model.Jugador;
import com.futpredict.backend.model.Partido;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // para conectar a React en el futuro

public class PrediccionController {

    // partidos de ejemplo por el momento:
    private List<Partido> partidos = crearPartidosEjemplo();



    //partidos para probar
    private List<Partido> crearPartidosEjemplo() {
        Jugador haaland = new Jugador("Haaland", "delantero", 9, "Noruega");
        Jugador salah = new Jugador("Salah", "Extremo", 11, "Egipto");

        Equipo city = new Equipo("Manchester City", "", "Inglaterra", "Premier League", List.of(haaland));
        Equipo liverpool = new Equipo("Liverpool", "", "Inglaterra", "Premier League", List.of(salah));

        Partido partido = new Partido(city, liverpool);
        partido.setId(1);
        partido.setResultado("LOCAL");
        partido.setProbLocal(0.52);
        partido.setProbEmpate(0.26);
        partido.setProbVisitante(0.22);
        partido.setGoleadorProbable("Haaland");
        partido.setProbGoleador(0.38);

        return List.of(partido);
    }


    //listar predicciones
    @GetMapping("/predicciones")
    public List<Partido> getPredicciones() {
        return partidos;
    }

    //buscar prediccion por id
    @GetMapping("/predicciones/{id}")
    public Partido getPrediccionById(@PathVariable int id) {
        return partidos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //listar equipos
    @GetMapping("/equipos")
    public List<Equipo> getEquipos(){
        return partidos.stream()
        .flatMap(p -> Stream.of(p.getEquipoLocal(),p.getEquipoVisitante()))
        .toList();
    }

    //listar jugadores
    @GetMapping("/jugadores")
    public List<Jugador> getJugadores(){
        return partidos.stream()
        .flatMap(p -> Stream.concat(p.getEquipoLocal().getJugadores().stream(), p.getEquipoVisitante().getJugadores().stream()))
        .toList();
    }



}
