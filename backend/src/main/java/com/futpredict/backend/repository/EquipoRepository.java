package com.futpredict.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futpredict.backend.entity.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    
}
