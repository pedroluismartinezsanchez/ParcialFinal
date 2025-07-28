/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepcion;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class ArchivoInvalidoExcepcion extends RuntimeException {
    public ArchivoInvalidoExcepcion(String mensaje) {
        super(mensaje);
    }

    public ArchivoInvalidoExcepcion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
