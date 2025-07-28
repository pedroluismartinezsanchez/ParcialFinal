/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Propietario extends Persona {
    private String direccion;
    private String telefono;

    public Propietario(String id, String nombre, String cedula, String direccion, String telefono) {
        super(id, nombre, cedula);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }

    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}

