/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

public class VeterinarioDTO {
    private String id;
    private String nombre;
    private String cedula;
    private String especialidad;
    private String registroProfesional;

    public VeterinarioDTO(String id, String nombre, String cedula, String especialidad, String registroProfesional) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.registroProfesional = registroProfesional;
    }

    // Getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getEspecialidad() { return especialidad; }
    public String getRegistroProfesional() { return registroProfesional; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setRegistroProfesional(String registroProfesional) { this.registroProfesional = registroProfesional; }
}
