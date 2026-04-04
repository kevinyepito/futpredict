package com.futpredict.backend.model;

import java.util.List;


public class Equipo {
    private String nombre;
    private String escudo; // url de imagen a futuro
    private String pais;
    private String competicion;
    private List<Jugador> jugadores;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Equipo(String nombre, String escudo, String pais, String competicion, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.pais = pais;
        this.competicion = competicion;
        this.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

}
