/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Mascota;
import persistencia.GestorPersistencia;
import java.util.List;

public class MascotaDAO {
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();
    private final String archivo = "data/mascotas.dat";

    public void guardar(List<Mascota> listaMascotas) {
        gestor.guardar(archivo, listaMascotas);
    }

    public List<Mascota> cargar() {
        return gestor.cargar(archivo);
    }
}

