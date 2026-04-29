package com.futpredict.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

    @JoinColumn(name = "resultado", nullable = false)
    private String resultado; // "LOCAL", "EMPATE", "VISITANTE"

    @Column(name = "probabilidad_local", nullable = false)
    private double probLocal;

    @Column(name = "probabilidad_empate", nullable = false)
    private double probEmpate;

    @Column(name = "probabilidad_visitante", nullable = false)
    private double probVisitante;

    @Column(name = "goleador_probable", nullable = false)
    private String goleadorProbable;

    @Column(name = "probabilidad_de_anotar", nullable = false)
    private double probGoleador;

    public Partido(){

    }

    

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double getProbLocal() {
        return probLocal;
    }

    public void setProbLocal(double probLocal) {
        this.probLocal = probLocal;
    }

    public double getProbEmpate() {
        return probEmpate;
    }

    public void setProbEmpate(double probEmpate) {
        this.probEmpate = probEmpate;
    }

    public double getProbVisitante() {
        return probVisitante;
    }

    public void setProbVisitante(double probVisitante) {
        this.probVisitante = probVisitante;
    }

    public String getGoleadorProbable() {
        return goleadorProbable;
    }

    public void setGoleadorProbable(String goleadorProbable) {
        this.goleadorProbable = goleadorProbable;
    }

    public double getProbGoleador() {
        return probGoleador;
    }

    public void setProbGoleador(double probGoleador) {
        this.probGoleador = probGoleador;
    }
}