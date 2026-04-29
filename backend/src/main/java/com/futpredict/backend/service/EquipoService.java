package com.futpredict.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.futpredict.backend.entity.Equipo;
import com.futpredict.backend.repository.EquipoRepository;
import java.util.List;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getAll() {
        return equipoRepository.findAll();
    }

    public Equipo getById(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void delete(Long id) {
        equipoRepository.deleteById(id);
    }

    public Equipo update(Long id, Equipo nuevo) {
        Equipo existente = equipoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(nuevo.getNombre());
            existente.setPais(nuevo.getPais());
            existente.setCompeticion(nuevo.getCompeticion());
            existente.setEscudo(nuevo.getEscudo());
            existente.setJugadores(nuevo.getJugadores());

            return equipoRepository.save(existente);
        }

        return null;
    }

}
