package com.portfolio.argprog.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String fechaE;
    private String tareasE;

    public Educacion() {
    }

    public Educacion(String nombreE, String descripcionE, String fechaE, String tareasE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaE = fechaE;
        this.tareasE = tareasE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
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
