/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepcion.DatoInvalidoExcepcion;
import dao.PropietarioDAO;
import dto.PropietarioDTO;
import modelo.Propietario;
import utils.IDGenerador;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class PropietarioControlador {

    private final PropietarioDAO dao = new PropietarioDAO();

    public void registrarPropietario(String nombre, String cedula, String direccion, String telefono) {
        if (nombre == null || nombre.isBlank()
                || cedula == null || cedula.isBlank()
                || direccion == null || direccion.isBlank()
                || telefono == null || telefono.isBlank()) {
            throw new DatoInvalidoExcepcion("Todos los campos son obligatorios para el propietario.");
        }

        String id = IDGenerador.generarID("P");
        Propietario p = new Propietario(id, nombre, cedula, direccion, telefono);
        List<Propietario> lista = dao.cargar();
        lista.add(p);
        dao.guardar(lista);
    }

    public List<PropietarioDTO> listarPropietarios() {
        return dao.cargar().stream()
                .map(p -> new PropietarioDTO(p.getId(), p.getNombre(), p.getCedula(), p.getDireccion(), p.getTelefono()))
                .collect(Collectors.toList());
    }

    public void eliminarPropietario(String id) {
        List<Propietario> lista = dao.cargar();
        boolean eliminado = lista.removeIf(p -> p.getId().equals(id));
        if (!eliminado) {
            throw new DatoInvalidoExcepcion("No se encontró propietario con ID: " + id);
        }
        dao.guardar(lista);
    }

    public void actualizarPropietario(String id, String nombre, String cedula, String direccion, String telefono) {
        if (nombre.isBlank() || cedula.isBlank() || direccion.isBlank() || telefono.isBlank()) {
            throw new DatoInvalidoExcepcion("Todos los campos deben estar llenos.");
        }

        List<Propietario> lista = dao.cargar();
        boolean actualizado = false;

        for (Propietario p : lista) {
            if (p.getId().equals(id)) {
                p.setNombre(nombre);
                p.setCedula(cedula);
                p.setDireccion(direccion);
                p.setTelefono(telefono);
                actualizado = true;
                break;
            }
        }

        if (!actualizado) {
            throw new DatoInvalidoExcepcion("No se encontró propietario con ese ID.");
        }

        dao.guardar(lista);
    }
}
