/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */



public class Estilo {

    public static final Color MORADO_OSCURO = new Color(102, 0, 153);
    public static final Color MORADO_CLARO = new Color(204, 153, 255);
    public static final Color TEXTO_CLARO = Color.WHITE;

    public static void aplicarEstiloVentana(JFrame ventana) {
        ventana.getContentPane().setBackground(MORADO_CLARO);
    }

    public static void aplicarEstiloPanel(JPanel panel) {
        panel.setBackground(MORADO_CLARO);
    }

    public static void aplicarEstiloBoton(JButton boton) {
        boton.setBackground(MORADO_OSCURO);
        boton.setForeground(TEXTO_CLARO);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    public static void aplicarEstiloEtiqueta(JLabel label) {
        label.setForeground(MORADO_OSCURO);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    }

    public static void aplicarEstiloTabla(JTable tabla) {
        tabla.setBackground(Color.WHITE);
        tabla.setForeground(Color.DARK_GRAY);
        tabla.setSelectionBackground(MORADO_OSCURO);
        tabla.setSelectionForeground(Color.WHITE);
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    }
}
