/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */

public class Pago implements Serializable {
    private String idPago;
    private String idConsulta;
    private String idPropietario;
    private double monto;
    private LocalDate fecha;

    public Pago(String idPago, String idConsulta, String idPropietario, double monto, LocalDate fecha) {
        this.idPago = idPago;
        this.idConsulta = idConsulta;
        this.idPropietario = idPropietario;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getIdPago() { return idPago; }
    public String getIdConsulta() { return idConsulta; }
    public String getIdPropietario() { return idPropietario; }
    public double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }

}

