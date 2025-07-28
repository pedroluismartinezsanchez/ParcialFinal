/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepcion.DatoInvalidoExcepcion;
import dao.MascotaDAO;
import dto.MascotaDTO;
import modelo.Mascota;
import utils.IDGenerador;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
import java.util.List;
import java.util.stream.Collectors;

public class MascotaControlador {

    private final MascotaDAO dao = new MascotaDAO();

    public void registrarMascota(String nombre, String especie, int edad) {
        if (nombre == null || nombre.isBlank() || especie == null || especie.isBlank() || edad < 0) {
            throw new DatoInvalidoExcepcion("Nombre, especie y edad deben ser válidos. La edad no puede ser negativa.");
        }

        String id = IDGenerador.generarID("M");
        Mascota mascota = new Mascota(id, nombre, especie, edad);
        List<Mascota> mascotas = dao.cargar();
        mascotas.add(mascota);
        dao.guardar(mascotas);
    }

    public List<MascotaDTO> listarMascotas() {
        return dao.cargar().stream()
                .map(m -> new MascotaDTO(m.getId(), m.getNombre(), m.getEspecie(), m.getEdad()))
                .collect(Collectors.toList());
    }

    public void eliminarMascota(String id) {
        List<Mascota> mascotas = dao.cargar();
        boolean eliminada = mascotas.removeIf(m -> m.getId().equals(id));
        if (!eliminada) {
            throw new DatoInvalidoExcepcion("No se encontró la mascota con ID: " + id);
        }
        dao.guardar(mascotas);
    }

    public void actualizarMascota(String id, String nombre, String especie, int edad) {
        if (nombre == null || nombre.isBlank() || especie == null || especie.isBlank() || edad < 0) {
            throw new DatoInvalidoExcepcion("Datos inválidos. Verifique los campos.");
        }

        List<Mascota> mascotas = dao.cargar();
        boolean actualizada = false;

        for (Mascota m : mascotas) {
            if (m.getId().equals(id)) {
                m.setNombre(nombre);
                m.setEspecie(especie);
                m.setEdad(edad);
                actualizada = true;
                break;
            }
        }

        if (!actualizada) {
            throw new DatoInvalidoExcepcion("No se encontró una mascota con ese ID.");
        }

        dao.guardar(mascotas);
    }
}
