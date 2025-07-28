/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */


public class HistorialClinico implements Serializable {
    private String id;
    private String idMascota;
    private LocalDate fecha;
    private String descripcion;
    private String tratamiento;

    public HistorialClinico(String id, String idMascota, LocalDate fecha, String descripcion, String tratamiento) {
        this.id = id;
        this.idMascota = idMascota;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
}
