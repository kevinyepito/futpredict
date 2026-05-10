package com.futpredict.backend;

import com.futpredict.backend.entity.*;
import com.futpredict.backend.repository.*;
import com.futpredict.backend.service.PartidoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final LigaRepository ligaRepository;
    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;
    private final PartidoService partidoService;

    public DataLoader(LigaRepository ligaRepository, EquipoRepository equipoRepository,
            JugadorRepository jugadorRepository, PartidoService partidoService) {
        this.ligaRepository = ligaRepository;
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
        this.partidoService = partidoService;
    }

    @Override
    public void run(String... args) {
        System.out.println("ENTRÓ AL DATALOADER");

        // Solo insertar si la BD está vacía
        if (ligaRepository.count() > 0) return;

        // ===== LIGAS =====
        Liga premierLeague = new Liga();
        premierLeague.setNombre("Premier League");
        premierLeague.setPais("Inglaterra");
        ligaRepository.save(premierLeague);

        Liga laLiga = new Liga();
        laLiga.setNombre("La Liga");
        laLiga.setPais("España");
        ligaRepository.save(laLiga);

        // ===== EQUIPOS =====
        Equipo city = new Equipo();
        city.setNombre("Manchester City");
        city.setPais("Inglaterra");
        city.setCompeticion("Premier League");
        city.setEscudo("");
        city.setLiga(premierLeague);
        equipoRepository.save(city);

        Equipo liverpool = new Equipo();
        liverpool.setNombre("Liverpool");
        liverpool.setPais("Inglaterra");
        liverpool.setCompeticion("Premier League");
        liverpool.setEscudo("");
        liverpool.setLiga(premierLeague);
        equipoRepository.save(liverpool);

        Equipo barcelona = new Equipo();
        barcelona.setNombre("Barcelona");
        barcelona.setPais("España");
        barcelona.setCompeticion("La Liga");
        barcelona.setEscudo("");
        barcelona.setLiga(laLiga);
        equipoRepository.save(barcelona);

        Equipo madrid = new Equipo();
        madrid.setNombre("Real Madrid");
        madrid.setPais("España");
        madrid.setCompeticion("La Liga");
        madrid.setEscudo("");
        madrid.setLiga(laLiga);
        equipoRepository.save(madrid);

        // ===== JUGADORES =====
        Jugador haaland = new Jugador("Haaland", "Delantero", 9, "Noruega", city);
        Jugador salah = new Jugador("Salah", "Extremo", 11, "Egipto", liverpool);
        Jugador lewandowski = new Jugador("Lewandowski", "Delantero", 9, "Polonia", barcelona);
        Jugador vinicius = new Jugador("Vinicius Jr", "Extremo", 7, "Brasil", madrid);
        jugadorRepository.saveAll(List.of(haaland, salah, lewandowski, vinicius));

        // ===== PARTIDOS =====
        Partido p1 = new Partido(city, liverpool);
        p1.setFechaPartido(LocalDateTime.now().plusDays(1));
        p1.setEstado("PENDIENTE");
        p1.setJornada(30);
        partidoService.save(p1);

        Partido p2 = new Partido(barcelona, madrid);
        p2.setFechaPartido(LocalDateTime.now().plusDays(2));
        p2.setEstado("PENDIENTE");
        p2.setJornada(30);
        partidoService.save(p2);

        System.out.println("DataLoader: datos iniciales insertados correctamente");
    }
}