/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepcion;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class DatoInvalidoExcepcion extends RuntimeException {
    public DatoInvalidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
