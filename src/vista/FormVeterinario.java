/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Excepcion.DatoInvalidoExcepcion;
import controlador.VeterinarioControlador;
import dto.VeterinarioDTO;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FormVeterinario extends JFrame {

    private JTextField txtNombre, txtCedula, txtEspecialidad, txtRegistro;
    private JTable tablaVeterinarios;
    private DefaultTableModel modeloTabla;

    private final VeterinarioControlador controlador = new VeterinarioControlador();

    public FormVeterinario() {
        setTitle("Gestión de Veterinarios");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
        cargarVeterinarios();
    }

    private void initUI() {
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Formulario Veterinario"));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelFormulario.add(txtCedula);

        panelFormulario.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        panelFormulario.add(txtEspecialidad);
        
        panelFormulario.add(new JLabel("Registro:"));
        txtRegistro = new JTextField();
        panelFormulario.add(txtRegistro);


        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrarVeterinario());
        panelFormulario.add(btnRegistrar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarVeterinario());
        panelFormulario.add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar Seleccionado");
        btnEliminar.addActionListener(e -> eliminarVeterinarioSeleccionado());
        panelFormulario.add(btnEliminar);

        JButton btnRefrescar = new JButton("Actualizar Lista");
        btnRefrescar.addActionListener(e -> cargarVeterinarios());
        panelFormulario.add(btnRefrescar);

        add(panelFormulario, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Cédula", "Especialidad","Registro"}, 0);
        tablaVeterinarios = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaVeterinarios);
        scroll.setBorder(BorderFactory.createTitledBorder("Veterinarios Registrados"));

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.addActionListener(e -> {
            dispose();
            new MenuPrincipal().setVisible(true);
        });
        panelInferior.add(btnVolver);

        add(panelInferior, BorderLayout.SOUTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void registrarVeterinario() {
        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        String registro = txtRegistro.getText().trim();
        
        

        try {
            controlador.registrarVeterinario(nombre, cedula, especialidad,registro );
            JOptionPane.showMessageDialog(this, "Veterinario registrado exitosamente.");
            limpiarCampos();
            cargarVeterinarios();
        } catch (DatoInvalidoExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarVeterinario() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del veterinario a actualizar:");
        if (id == null || id.trim().isEmpty()) return;

        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        String registro = txtRegistro.getText().trim();

        try {
            controlador.actualizarVeterinario(id.trim(), nombre, cedula, especialidad, registro);
            JOptionPane.showMessageDialog(this, "Veterinario actualizado exitosamente.");
            limpiarCampos();
            cargarVeterinarios();
        } catch (DatoInvalidoExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarVeterinarioSeleccionado() {
        int fila = tablaVeterinarios.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un veterinario para eliminar.");
            return;
        }

        String id = modeloTabla.getValueAt(fila, 0).toString();
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Eliminar veterinario con ID " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                controlador.eliminarVeterinario(id);
                JOptionPane.showMessageDialog(this, "Veterinario eliminado.");
                cargarVeterinarios();
            } catch (DatoInvalidoExcepcion e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCedula.setText("");
        txtEspecialidad.setText("");
        txtRegistro.setText("");
    }

    private void cargarVeterinarios() {
        modeloTabla.setRowCount(0);
        List<VeterinarioDTO> lista = controlador.listarVeterinarios();
        for (VeterinarioDTO v : lista) {
            modeloTabla.addRow(new Object[]{
                    v.getId(), v.getNombre(), v.getCedula(), v.getEspecialidad(),v.getRegistroProfesional()
            });
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
            java.util.logging.Logger.getLogger(FormVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVeterinario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
