package com.futpredict.backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "escudo", nullable = true)
    private String escudo; // url de imagen a futuro

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "competicion", nullable = false)
    private String competicion;

    @OneToMany(mappedBy = "equipo",cascade = CascadeType.ALL)
    private List<Jugador> jugadores;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "liga_id")
    private Liga liga;

    public Equipo() {
    }

    public Equipo(String nombre, String escudo, String pais, String competicion, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.pais = pais;
        this.competicion = competicion;
        this.jugadores = jugadores;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

}
