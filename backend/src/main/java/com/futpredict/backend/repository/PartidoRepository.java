package com.futpredict.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futpredict.backend.entity.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    
}
