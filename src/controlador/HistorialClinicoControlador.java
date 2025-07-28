/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */


import Excepcion.DatoInvalidoExcepcion;
import accesoDatos.HistorialClinicoDAO;
import modelo.HistorialClinico;
import transferencia.HistorialClinicoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.IDGenerador;

public class HistorialClinicoControlador {

    private final HistorialClinicoDAO dao = new HistorialClinicoDAO();

    public void registrarEntrada(String idMascota, String descripcion, String tratamiento) {
        if (descripcion.isBlank() || tratamiento.isBlank()) {
            throw new DatoInvalidoExcepcion("Descripción y tratamiento son obligatorios.");
        }

        String id = IDGenerador.generarID("Historial");
        HistorialClinico h = new HistorialClinico(id, idMascota, LocalDate.now(), descripcion, tratamiento);

        List<HistorialClinico> lista = dao.cargar();
        lista.add(h);
        dao.guardar(lista);
    }

    public List<HistorialClinicoDTO> listarPorMascota(String idMascota) {
        List<HistorialClinicoDTO> dtos = new ArrayList<>();
        for (HistorialClinico h : dao.cargar()) {
            if (h.getIdMascota().equals(idMascota)) {
                dtos.add(new HistorialClinicoDTO(h.getId(), h.getIdMascota(), h.getFecha(), h.getDescripcion(), h.getTratamiento()));
            }
        }
        return dtos;
    }
}

