/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepcion.DatoInvalidoExcepcion;
import dao.VeterinarioDAO;
import dto.VeterinarioDTO;
import modelo.Veterinario;
import utils.IDGenerador;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class VeterinarioControlador {

    private final VeterinarioDAO dao = new VeterinarioDAO();

    public void registrarVeterinario(String nombre, String cedula, String especialidad, String registro) {
        if (nombre == null || nombre.isBlank()
                || cedula == null || cedula.isBlank()
                || especialidad == null || especialidad.isBlank()
                || registro == null || registro.isBlank()) {
            throw new DatoInvalidoExcepcion("Todos los campos son obligatorios para el veterinario.");
        }

        String id = IDGenerador.generarID("V");
        Veterinario v = new Veterinario(id, nombre, cedula, especialidad, registro);
        List<Veterinario> lista = dao.cargar();
        lista.add(v);
        dao.guardar(lista);
    }

    public List<VeterinarioDTO> listarVeterinarios() {
        return dao.cargar().stream()
                .map(v -> new VeterinarioDTO(v.getId(), v.getNombre(), v.getCedula(), v.getEspecialidad(), v.getRegistroProfesional()))
                .collect(Collectors.toList());
    }

    public void eliminarVeterinario(String id) {
        List<Veterinario> lista = dao.cargar();
        boolean eliminado = lista.removeIf(v -> v.getId().equals(id));
        if (!eliminado) {
            throw new DatoInvalidoExcepcion("No se encontró veterinario con ID: " + id);
        }
        dao.guardar(lista);
    }

    public void actualizarVeterinario(String id, String nombre, String cedula, String especialidad, String telefono) {
        if (nombre.isBlank() || cedula.isBlank() || especialidad.isBlank() || telefono.isBlank()) {
            throw new DatoInvalidoExcepcion("Todos los campos son obligatorios.");
        }

        List<Veterinario> lista = dao.cargar();
        boolean actualizado = false;

        for (Veterinario v : lista) {
            if (v.getId().equals(id)) {
                v.setNombre(nombre);
                v.setCedula(cedula);
                v.setEspecialidad(especialidad);
                actualizado = true;
                break;
            }
        }

        if (!actualizado) {
            throw new DatoInvalidoExcepcion("No se encontró veterinario con ese ID.");
        }

        dao.guardar(lista);
    }

}
