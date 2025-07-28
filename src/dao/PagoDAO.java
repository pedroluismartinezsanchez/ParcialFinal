/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Pago;
import persistencia.GestorPersistencia;
import java.util.List;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */

public class PagoDAO {
    private final String archivo = "data/pagos.dat";

    public void guardar(List<Pago> lista) {
        GestorPersistencia.getInstancia().escribir(archivo, lista);
    }

    public List<Pago> cargar() {
        return GestorPersistencia.getInstancia().leer(archivo);
    }
}

