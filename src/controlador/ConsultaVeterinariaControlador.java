/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Excepcion.DatoInvalidoExcepcion;
import accesoDatos.ConsultaVeterinariaDAO;
import modelo.ConsultaVeterinaria;
import transferencia.ConsultaVeterinariaDTO;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.IDGenerador;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */




public class ConsultaVeterinariaControlador {

    private final ConsultaVeterinariaDAO dao = new ConsultaVeterinariaDAO();

    public void registrarConsulta(String idMascota, String idVeterinario, String motivo, String diagnostico, String tratamiento,boolean vacunaAplicada) {
        if (idMascota.isBlank() || idVeterinario.isBlank() || motivo.isBlank() || diagnostico.isBlank() || tratamiento.isBlank()) {
            throw new DatoInvalidoExcepcion("Todos los campos son obligatorios.");
        }

        String idConsulta = IDGenerador.generarID("CON");
        ConsultaVeterinaria consulta = new ConsultaVeterinaria(
                idConsulta, idMascota, idVeterinario,
                LocalDate.now(), motivo, diagnostico, tratamiento,vacunaAplicada
        );

        List<ConsultaVeterinaria> consultas = dao.cargar();
        consultas.add(consulta);
        dao.guardar(consultas);
    }

    public List<ConsultaVeterinariaDTO> listarConsultas() {
        List<ConsultaVeterinariaDTO> dtos = new ArrayList<>();

        for (ConsultaVeterinaria c : dao.cargar()) {
            ConsultaVeterinariaDTO dto = new ConsultaVeterinariaDTO(
                    c.getIdConsulta(), c.getIdMascota(), c.getIdVeterinario(),
                    c.getFecha(), c.getMotivo(), c.getDiagnostico(), c.getTratamiento(),c.isVacunaAplicada()
            );
            dtos.add(dto);
        }

        return dtos;
    }

    public List<ConsultaVeterinariaDTO> listarPorMascota(String idMascota) {
        List<ConsultaVeterinariaDTO> dtos = new ArrayList<>();

        for (ConsultaVeterinaria c : dao.cargar()) {
            if (c.getIdMascota().equalsIgnoreCase(idMascota)) {
                dtos.add(new ConsultaVeterinariaDTO(
                        c.getIdConsulta(), c.getIdMascota(), c.getIdVeterinario(),
                        c.getFecha(), c.getMotivo(), c.getDiagnostico(), c.getTratamiento(),c.isVacunaAplicada()
                ));
            }
        }

        return dtos;
    }
    
    public void eliminarConsulta(String idConsulta) {
    List<ConsultaVeterinaria> consultas = dao.cargar();
    boolean eliminado = consultas.removeIf(c -> c.getIdConsulta().equalsIgnoreCase(idConsulta));
    if (eliminado) {
        dao.guardar(consultas);
    } else {
        throw new DatoInvalidoExcepcion("No se encontró la consulta con ID: " + idConsulta);
    }
}

}

