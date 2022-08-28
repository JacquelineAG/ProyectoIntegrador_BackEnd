package com.portfolio.argprog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String fechaE;
    private String tareasE;
    
    // Constructores

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String fechaE, String tareasE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaE = fechaE;
        this.tareasE = tareasE;
    }

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
    
        public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }
    
    public String getTareasE() {
        return tareasE;
    }

    public void setTareasE(String tareasE) {
        this.tareasE = tareasE;
    }
}
