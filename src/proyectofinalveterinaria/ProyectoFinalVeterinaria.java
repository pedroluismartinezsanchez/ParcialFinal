/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalveterinaria;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import vista.MenuPrincipal;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class ProyectoFinalVeterinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Establecer estilo visual del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el estilo visual.");
        }

        // Lanza la ventana principal
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        });
    }

}
