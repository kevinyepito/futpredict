package com.futpredict.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.futpredict.backend.entity.Partido;
import com.futpredict.backend.repository.PartidoRepository;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> getAll() {
        return partidoRepository.findAll();
    }

    public Partido getById(Long id) {
        return partidoRepository.findById(id).orElse(null);
    }

    public Partido save(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void delete(Long id) {
        partidoRepository.deleteById(id);
    }

    public Partido update(Long id, Partido nuevo) {
        Partido existente = partidoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setEquipoLocal(nuevo.getEquipoLocal());
            existente.setEquipoVisitante(nuevo.getEquipoVisitante());
            existente.setGoleadorProbable(nuevo.getGoleadorProbable());
            existente.setProbEmpate(nuevo.getProbEmpate());
            existente.setProbGoleador(nuevo.getProbGoleador());
            existente.setProbLocal(nuevo.getProbLocal());
            existente.setProbVisitante(nuevo.getProbVisitante());
            existente.setResultado(nuevo.getResultado());

            return partidoRepository.save(existente);
        }

        return null;
    }
    
}
