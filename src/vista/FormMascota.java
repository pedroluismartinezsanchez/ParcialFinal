/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Excepcion.DatoInvalidoExcepcion;
import controlador.MascotaControlador;
import dto.MascotaDTO;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FormMascota extends JFrame {

    private JTextField txtNombre;
    private JTextField txtEspecie;
    private JTextField txtEdad;
    private JTable tablaMascotas;
    private DefaultTableModel modeloTabla;

    private final MascotaControlador controller = new MascotaControlador();

    public FormMascota() {
        setTitle("Gestión de Mascotas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
        cargarMascotas();
    }

    private void initUI() {
        // Panel superior - formulario
        JPanel panelFormulario = new JPanel(new GridLayout(5, 5, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Registrar Nueva Mascota"));
        
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Especie:"));
        txtEspecie = new JTextField();
        panelFormulario.add(txtEspecie);

        panelFormulario.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelFormulario.add(txtEdad);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrarMascota());
        panelFormulario.add(btnRegistrar);
        
        JButton btnActualizarMascota = new JButton("Actualizar");
        btnActualizarMascota.addActionListener(e -> actualizarMascota());
        panelFormulario.add(btnActualizarMascota);

        JButton btnEliminar = new JButton("Eliminar Seleccionada");
        btnEliminar.addActionListener(e -> eliminarMascotaSeleccionada());
        panelFormulario.add(btnEliminar);
        
        add(panelFormulario, BorderLayout.NORTH);

        // Panel inferior - tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Especie", "Edad"}, 0);
        tablaMascotas = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaMascotas);
        scroll.setBorder(BorderFactory.createTitledBorder("Mascotas Registradas"));
        
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.addActionListener(e -> {
            dispose();
            new MenuPrincipal().setVisible(true);
        });
        panelInferior.add(btnVolver);

        add(panelInferior, BorderLayout.SOUTH);
        add(scroll, BorderLayout.CENTER);
        
        JButton btnActualizar = new JButton("Actualizar Lista");
        btnActualizar.addActionListener(e -> cargarMascotas());
        panelFormulario.add(btnActualizar);
        
    }

    private void registrarMascota() {
        String nombre = txtNombre.getText().trim();
        String especie = txtEspecie.getText().trim();
        String edadTexto = txtEdad.getText().trim();

        try {
            int edad = Integer.parseInt(edadTexto);
            controller.registrarMascota(nombre, especie, edad);
            JOptionPane.showMessageDialog(this, "Mascota registrada exitosamente.");
            limpiarCampos();
            cargarMascotas();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DatoInvalidoExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void actualizarMascota() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID de la mascota a actualizar:");
        if (id == null || id.trim().isEmpty()) {
            return; // Cancelado
        }

        String nombre = txtNombre.getText().trim();
        String especie = txtEspecie.getText().trim();
        String edadTexto = txtEdad.getText().trim();

        try {
            int edad = Integer.parseInt(edadTexto);
            controller.actualizarMascota(id.trim(), nombre, especie, edad);
            JOptionPane.showMessageDialog(this, "Mascota actualizada exitosamente.");
            limpiarCampos();
            cargarMascotas();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DatoInvalidoExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarMascotaSeleccionada() {
        int fila = tablaMascotas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una mascota de la tabla para eliminar.");
            return;
        }

        String id = modeloTabla.getValueAt(fila, 0).toString();
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar la mascota con ID " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                controller.eliminarMascota(id);
                JOptionPane.showMessageDialog(this, "Mascota eliminada.");
                cargarMascotas();
            } catch (DatoInvalidoExcepcion e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEspecie.setText("");
        txtEdad.setText("");
    }

    private void cargarMascotas() {
        modeloTabla.setRowCount(0); // Limpiar tabla
        List<MascotaDTO> mascotas = controller.listarMascotas();
        for (MascotaDTO m : mascotas) {
            modeloTabla.addRow(new Object[]{m.getId(), m.getNombre(), m.getEspecie(), m.getEdad()});
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMascota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
