package com.futpredict.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futpredict.backend.entity.Equipo;
import com.futpredict.backend.entity.Jugador;
import com.futpredict.backend.entity.Partido;
import com.futpredict.backend.service.EquipoService;
import com.futpredict.backend.service.IAService;
import com.futpredict.backend.service.JugadorService;
import com.futpredict.backend.service.PartidoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:5173", "http://localhost" })

public class PrediccionController {

        private final EquipoService equipoService;
        private final JugadorService jugadorService;
        private final PartidoService partidoService;
        private final IAService iaService;

        public PrediccionController(PartidoService partidoService,
                        EquipoService equipoService,
                        JugadorService jugadorService, IAService iaService) {
                this.partidoService = partidoService;
                this.equipoService = equipoService;
                this.jugadorService = jugadorService;
                this.iaService = iaService;
        }

        /*
         * datos de prueba
         * // partidos de ejemplo por el momento:
         * private List<Partido> partidos = crearPartidosEjemplo();
         * 
         * // partidos para probar
         * private List<Partido> crearPartidosEjemplo() {
         * 
         * // ===== JUGADORES =====
         * Jugador haaland = new Jugador("Haaland", "Delantero", 9, "Noruega");
         * Jugador salah = new Jugador("Salah", "Extremo", 11, "Egipto");
         * Jugador mbappe = new Jugador("Mbappé", "Delantero", 7, "Francia");
         * Jugador lewandowski = new Jugador("Lewandowski", "Delantero", 9, "Polonia");
         * Jugador vinicius = new Jugador("Vinicius Jr", "Extremo", 7, "Brasil");
         * Jugador lautaro = new Jugador("Lautaro Martínez", "Delantero", 10,
         * "Argentina");
         * Jugador dybala = new Jugador("Dybala", "Media punta", 21, "Argentina");
         * 
         * // ===== EQUIPOS =====
         * Equipo city = new Equipo(
         * "Manchester City",
         * "https://via.placeholder.com/30",
         * "Inglaterra",
         * "Premier League",
         * List.of(haaland));
         * 
         * Equipo liverpool = new Equipo(
         * "Liverpool",
         * "https://via.placeholder.com/30",
         * "Inglaterra",
         * "Premier League",
         * List.of(salah));
         * 
         * Equipo psg = new Equipo(
         * "PSG",
         * "https://via.placeholder.com/30",
         * "Francia",
         * "Ligue 1",
         * List.of(mbappe));
         * 
         * Equipo barcelona = new Equipo(
         * "Barcelona",
         * "https://via.placeholder.com/30",
         * "España",
         * "La Liga",
         * List.of(lewandowski));
         * 
         * Equipo madrid = new Equipo(
         * "Real Madrid",
         * "https://via.placeholder.com/30",
         * "España",
         * "La Liga",
         * List.of(vinicius));
         * 
         * Equipo inter = new Equipo(
         * "Inter",
         * "https://via.placeholder.com/30",
         * "Italia",
         * "Serie A",
         * List.of(lautaro));
         * 
         * Equipo roma = new Equipo(
         * "Roma",
         * "https://via.placeholder.com/30",
         * "Italia",
         * "Serie A",
         * List.of(dybala));
         * 
         * // ===== PARTIDOS =====
         * Partido p1 = new Partido(city, liverpool);
         * p1.setId(1);
         * p1.setProbLocal(0.55);
         * p1.setProbEmpate(0.25);
         * p1.setProbVisitante(0.20);
         * p1.setGoleadorProbable("Haaland");
         * p1.setProbGoleador(0.28);
         * 
         * Partido p2 = new Partido(psg, barcelona);
         * p2.setId(2);
         * p2.setProbLocal(0.48);
         * p2.setProbEmpate(0.27);
         * p2.setProbVisitante(0.25);
         * p2.setGoleadorProbable("Mbappé");
         * p2.setProbGoleador(0.58);
         * 
         * Partido p3 = new Partido(madrid, inter);
         * p3.setId(3);
         * p3.setProbLocal(0.60);
         * p3.setProbEmpate(0.20);
         * p3.setProbVisitante(0.20);
         * p3.setGoleadorProbable("Vinicius Jr");
         * p3.setProbGoleador(0.12);
         * 
         * Partido p4 = new Partido(roma, city);
         * p4.setId(4);
         * p4.setProbLocal(0.30);
         * p4.setProbEmpate(0.30);
         * p4.setProbVisitante(0.40);
         * p4.setGoleadorProbable("Haaland");
         * p4.setProbGoleador(0.68);
         * 
         * return List.of(p1, p2, p3, p4);
         * }
         */

        // Predicciones--------------------------------------------------------------------------
        @GetMapping("/predicciones")
        public List<Partido> getPredicciones() {
                return partidoService.getAll();
        }

        // buscar prediccion por id
        @GetMapping("/predicciones/{id}")
        public Partido getPrediccionById(@PathVariable Long id) {
                return partidoService.getById(id);
        }

        @PostMapping("/predicciones")
        public Partido savePartido(@RequestBody Partido partido) {
                return partidoService.save(partido);
        }

        @DeleteMapping("/predicciones/{id}")
        public void deletePartido(@PathVariable Long id) {
                partidoService.delete(id);
        }

        @PutMapping("/predicciones/{id}")
        public Partido updatePartido(@PathVariable Long id, @RequestBody Partido partido) {
                return partidoService.update(id, partido);
        }
        // --------------------------------------------------------------------------------------------

        // equipos-----------------------------------------------------------------------------------------
        @GetMapping("/equipos")
        public List<Equipo> getEquipos() {
                return equipoService.getAll();
        }

        @GetMapping("/equipos/{id}")
        public Equipo getEquipoById(@PathVariable Long id) {
                return equipoService.getById(id);
        }

        @PostMapping("/equipos")
        public Equipo saveEquipo(@RequestBody Equipo equipo) {
                return equipoService.save(equipo);
        }

        @DeleteMapping("/equipos/{id}")
        public void deleteEquipo(@PathVariable Long id) {
                equipoService.delete(id);
        }

        @PutMapping("/equipos/{id}")
        public Equipo updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
                return equipoService.update(id, equipo);
        }

        // -------------------------------------------------------------------------------------------

        // jugador--------------------------------------------------------------------------------------------
        @GetMapping("/jugadores")
        public List<Jugador> getJugadores() {
                return jugadorService.getAll();
        }

        @GetMapping("/jugadores/{id}")
        public Jugador getJugadorById(@PathVariable Long id) {
                return jugadorService.getById(id);
        }

        @PostMapping("/jugadores")
        public Jugador saveJugador(@RequestBody Jugador jugador) {
                return jugadorService.save(jugador);
        }

        @DeleteMapping("/jugadores/{id}")
        public void deleteJugador(@PathVariable Long id) {
                jugadorService.delete(id);
        }

        @PutMapping("/jugadores/{id}")
        public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
                return jugadorService.update(id, jugador);
        }

        // ---------------------------------------

        //servicio de IA 🤖---------------------------------------------------------------------
        @PostMapping("/predecir")
        public Map<String, Object> predeMap(@RequestBody Map<String, Object> datos) {
            
            return iaService.predecir(datos);
        }
        
}
