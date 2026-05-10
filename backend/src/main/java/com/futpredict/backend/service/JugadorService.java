package com.futpredict.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.futpredict.backend.entity.Jugador;
import com.futpredict.backend.repository.JugadorRepository;

@Service
public class JugadorService {
    
    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<Jugador> getAll() {
        return jugadorRepository.findAll();
    }

    public Jugador getById(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void delete(Long id) {
        jugadorRepository.deleteById(id);
    }

    public Jugador update(Long id, Jugador nuevo) {
        Jugador existente = jugadorRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(nuevo.getNombre());
            existente.setNacionalidad(nuevo.getNacionalidad());
            existente.setNumeroCamiseta(nuevo.getNumeroCamiseta());
            existente.setPosicion(nuevo.getPosicion());

            return jugadorRepository.save(existente);
        }

        return null;
    }
}
