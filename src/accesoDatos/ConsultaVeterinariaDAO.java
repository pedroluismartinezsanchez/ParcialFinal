/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;
import modelo.ConsultaVeterinaria;
import persistencia.GestorPersistencia;

import java.util.List;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */

public class ConsultaVeterinariaDAO {

    private final String archivo = "data/consultas.dat";

    public List<ConsultaVeterinaria> cargar() {
        return GestorPersistencia.getInstancia().leer(archivo);
    }

    public void guardar(List<ConsultaVeterinaria> consultas) {
        GestorPersistencia.getInstancia().escribir(archivo, consultas);
    }
}

