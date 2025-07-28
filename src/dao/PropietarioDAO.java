/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Propietario;
import persistencia.GestorPersistencia;
import java.util.List;

public class PropietarioDAO {
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();
    private final String archivo = "data/propietarios.dat";

    public void guardar(List<Propietario> listaPropietarios) {
        gestor.guardar(archivo, listaPropietarios);
    }

    public List<Propietario> cargar() {
        return gestor.cargar(archivo);
    }
}

