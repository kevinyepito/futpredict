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

    // partidos para probar
    private List<Partido> crearPartidosEjemplo() {

        // ===== JUGADORES =====
        Jugador haaland = new Jugador("Haaland", "Delantero", 9, "Noruega");
        Jugador salah = new Jugador("Salah", "Extremo", 11, "Egipto");
        Jugador mbappe = new Jugador("Mbappé", "Delantero", 7, "Francia");
        Jugador lewandowski = new Jugador("Lewandowski", "Delantero", 9, "Polonia");
        Jugador vinicius = new Jugador("Vinicius Jr", "Extremo", 7, "Brasil");
        Jugador lautaro = new Jugador("Lautaro Martínez", "Delantero", 10, "Argentina");
        Jugador dybala = new Jugador("Dybala", "Media punta", 21, "Argentina");

        // ===== EQUIPOS =====
        Equipo city = new Equipo(
                "Manchester City",
                "https://via.placeholder.com/30",
                "Inglaterra",
                "Premier League",
                List.of(haaland));

        Equipo liverpool = new Equipo(
                "Liverpool",
                "https://via.placeholder.com/30",
                "Inglaterra",
                "Premier League",
                List.of(salah));

        Equipo psg = new Equipo(
                "PSG",
                "https://via.placeholder.com/30",
                "Francia",
                "Ligue 1",
                List.of(mbappe));

        Equipo barcelona = new Equipo(
                "Barcelona",
                "https://via.placeholder.com/30",
                "España",
                "La Liga",
                List.of(lewandowski));

        Equipo madrid = new Equipo(
                "Real Madrid",
                "https://via.placeholder.com/30",
                "España",
                "La Liga",
                List.of(vinicius));

        Equipo inter = new Equipo(
                "Inter",
                "https://via.placeholder.com/30",
                "Italia",
                "Serie A",
                List.of(lautaro));

        Equipo roma = new Equipo(
                "Roma",
                "https://via.placeholder.com/30",
                "Italia",
                "Serie A",
                List.of(dybala));

        // ===== PARTIDOS =====
        Partido p1 = new Partido(city, liverpool);
        p1.setId(1);
        p1.setProbLocal(0.55);
        p1.setProbEmpate(0.25);
        p1.setProbVisitante(0.20);
        p1.setGoleadorProbable("Haaland");
        p1.setProbGoleador(0.28);

        Partido p2 = new Partido(psg, barcelona);
        p2.setId(2);
        p2.setProbLocal(0.48);
        p2.setProbEmpate(0.27);
        p2.setProbVisitante(0.25);
        p2.setGoleadorProbable("Mbappé");
        p2.setProbGoleador(0.58);

        Partido p3 = new Partido(madrid, inter);
        p3.setId(3);
        p3.setProbLocal(0.60);
        p3.setProbEmpate(0.20);
        p3.setProbVisitante(0.20);
        p3.setGoleadorProbable("Vinicius Jr");
        p3.setProbGoleador(0.12);

        Partido p4 = new Partido(roma, city);
        p4.setId(4);
        p4.setProbLocal(0.30);
        p4.setProbEmpate(0.30);
        p4.setProbVisitante(0.40);
        p4.setGoleadorProbable("Haaland");
        p4.setProbGoleador(0.68);

        return List.of(p1, p2, p3, p4);
    }

    // listar predicciones
    @GetMapping("/predicciones")
    public List<Partido> getPredicciones() {
        return partidos;
    }

    // buscar prediccion por id
    @GetMapping("/predicciones/{id}")
    public Partido getPrediccionById(@PathVariable int id) {
        return partidos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // listar equipos
    @GetMapping("/equipos")
    public List<Equipo> getEquipos() {
        return partidos.stream()
                .flatMap(p -> Stream.of(p.getEquipoLocal(), p.getEquipoVisitante()))
                .toList();
    }

    // listar jugadores
    @GetMapping("/jugadores")
    public List<Jugador> getJugadores() {
        return partidos.stream()
                .flatMap(p -> Stream.concat(p.getEquipoLocal().getJugadores().stream(),
                        p.getEquipoVisitante().getJugadores().stream()))
                .toList();
    }

}
