package com.futpredict.backend.model;


public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String resultado; // "LOCAL", "EMPATE", "VISITANTE"
    private double probLocal;
    private double probEmpate;
    private double probVisitante;
    private String goleadorProbable;
    private double probGoleador;

    private long id;

    

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