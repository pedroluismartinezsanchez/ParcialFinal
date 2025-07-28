/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Veterinario extends Persona {
    private String especialidad;
    private String registroProfesional;

    public Veterinario(String id, String nombre, String cedula, String especialidad, String registroProfesional) {
        super(id, nombre, cedula);
        this.especialidad = especialidad;
        this.registroProfesional = registroProfesional;
    }

    // Getters y setters
    public String getEspecialidad() { return especialidad; }
    public String getRegistroProfesional() { return registroProfesional; }

    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setRegistroProfesional(String registroProfesional) { this.registroProfesional = registroProfesional; }
}
