/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class IDGenerador {

    private static final Map<String, Integer> contadorPorPrefijo = new HashMap<>();

    public static String generarID(String prefijo) {
        int nuevoNumero = contadorPorPrefijo.getOrDefault(prefijo, 0) + 1;
        contadorPorPrefijo.put(prefijo, nuevoNumero);
        return String.format("%s%03d", prefijo, nuevoNumero);
    }

    // Si deseas reiniciar los contadores (opcional)
    public static void reiniciar() {
        contadorPorPrefijo.clear();
    }
}

