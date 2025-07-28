/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */

import modelo.HistorialClinico;
import persistencia.GestorPersistencia;
import java.util.List;

public class HistorialClinicoDAO {
    private final String archivo = "data/historiales.dat";

    public List<HistorialClinico> cargar() {
        return GestorPersistencia.getInstancia().leer(archivo);
    }

    public void guardar(List<HistorialClinico> historial) {
        GestorPersistencia.getInstancia().escribir(archivo, historial);
    }
}

