/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Veterinario;
import persistencia.GestorPersistencia;
import java.util.List;

public class VeterinarioDAO {
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();
    private final String archivo = "data/veterinarios.dat";

    public void guardar(List<Veterinario> listaVeterinarios) {
        gestor.guardar(archivo, listaVeterinarios);
    }

    public List<Veterinario> cargar() {
        return gestor.cargar(archivo);
    }
}

