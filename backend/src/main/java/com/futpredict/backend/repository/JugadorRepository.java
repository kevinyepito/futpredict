package com.futpredict.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futpredict.backend.entity.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    
}
