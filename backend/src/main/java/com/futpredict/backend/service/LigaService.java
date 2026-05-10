package com.futpredict.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.futpredict.backend.entity.Liga;
import com.futpredict.backend.repository.LigaRepository;

@Service
public class LigaService {

    private final LigaRepository ligaRepository;

    public LigaService(LigaRepository ligaRepository) {
        this.ligaRepository = ligaRepository;
    }

    public List<Liga> getAll() {
        return ligaRepository.findAll();
    }

    public Liga getById(Long id) {
        return ligaRepository.findById(id).orElse(null);
    }

    public Liga save(Liga liga) {
        return ligaRepository.save(liga);
    }

    public void delete(Long id) {
        ligaRepository.deleteById(id);
    }

    public Liga update(Long id, Liga nueva){
        Liga existente = ligaRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(nueva.getNombre());
            existente.setLogo(nueva.getLogo());
            existente.setPais(nueva.getPais());

            return ligaRepository.save(existente);
        }
        return null;

    }

}
