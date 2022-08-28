package com.portfolio.argprog.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    
    @NotBlank
    private String descripcionE;
    
    @NotBlank
    private String fechaE;
        
    @NotBlank
    private String tareasE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String fechaE, String tareasE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaE = fechaE;
        this.tareasE = tareasE;
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