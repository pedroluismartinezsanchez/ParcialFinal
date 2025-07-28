/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Excepcion.DatoInvalidoExcepcion;
import dao.PagoDAO;
import dto.PagoDTO;

import modelo.Pago;
import utils.IDGenerador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */

public class PagoControlador {

    private final PagoDAO dao = new PagoDAO();

    public void registrarPago(String idConsulta, String idPropietario, double monto) {
        if (idConsulta.isBlank() || idPropietario.isBlank()) {
            throw new DatoInvalidoExcepcion("Consulta y propietario son obligatorios.");
        }

        if (monto <= 0) {
            throw new DatoInvalidoExcepcion("El monto debe ser mayor a cero.");
        }

        String idPago = IDGenerador.generarID("PAG");
        Pago pago = new Pago(idPago, idConsulta, idPropietario, monto, LocalDate.now());

        List<Pago> pagos = dao.cargar();
        pagos.add(pago);
        dao.guardar(pagos);
    }

    public List<PagoDTO> listarPagos() {
        List<Pago> pagos = dao.cargar();
        List<PagoDTO> dtos = new ArrayList<>();

        for (Pago p : pagos) {
            dtos.add(new PagoDTO(
                    p.getIdPago(),
                    p.getIdConsulta(),
                    p.getIdPropietario(),
                    p.getMonto(),
                    p.getFecha()
            ));
        }

        return dtos;
    }

    public List<PagoDTO> listarPorPropietario(String idPropietario) {
        List<Pago> pagos = dao.cargar();
        List<PagoDTO> dtos = new ArrayList<>();

        for (Pago p : pagos) {
            if (p.getIdPropietario().equalsIgnoreCase(idPropietario)) {
                dtos.add(new PagoDTO(
                        p.getIdPago(),
                        p.getIdConsulta(),
                        p.getIdPropietario(),
                        p.getMonto(),
                        p.getFecha()
                ));
            }
        }

        return dtos;
    }
}
