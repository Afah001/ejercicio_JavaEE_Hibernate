/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.Set;


public class atleta {
    
    private int idatleta;
    private String nombre;
    private String apellido;
    private Date fecha;
    private String documento;
    
    private Set<carrera>carreras; 

    public atleta(){
    }

    public atleta(String nombre,String apellido,Date fecha,String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.documento = documento;
    }

    public int getIdatleta() {
        return idatleta;
    }

    public void setIdatleta(int idatleta) {
        this.idatleta = idatleta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Set<carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<carrera> carreras) {
        this.carreras = carreras;
    }
    
}
