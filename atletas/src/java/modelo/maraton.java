/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.Set;


public class maraton {
    
    private int idmaraton;
    private Date fecha;
    private String organizador;
    private String estado;
   
    private Set<carrera>carreras;

    public maraton() {
    }

    public maraton(Date fecha, String organizador) {
        this.fecha = fecha;
        this.organizador = organizador;
        this.estado = "PROCESO";
    }

    public int getIdmaraton() {
        return idmaraton;
    }

    public void setIdmaraton(int idmaraton) {
        this.idmaraton = idmaraton;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<carrera> carreras) {
        this.carreras = carreras;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<carrera> getCarrreras() {
        return carreras;
    }

    public void setCarrreras(Set<carrera> carrreras) {
        this.carreras = carrreras;
    }
    
    
}
