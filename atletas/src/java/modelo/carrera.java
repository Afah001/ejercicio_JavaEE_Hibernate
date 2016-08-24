/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;


public class carrera {
    private int idcarrera;
    private Date fecha;
   
    private String estado;

    private atleta atleta;
    private maraton maraton;

    public carrera() {
    }

    public carrera(Date fecha, atleta atleta, maraton maraton) {
        this.fecha = fecha;
     
        this.estado = "PROCESO";
        this.atleta = atleta;
        this.maraton = maraton;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(atleta atleta) {
        this.atleta = atleta;
    }

    public maraton getMaraton() {
        return maraton;
    }

    public void setMaraton(maraton maraton) {
        this.maraton = maraton;
    }
    
    
    
    
}
