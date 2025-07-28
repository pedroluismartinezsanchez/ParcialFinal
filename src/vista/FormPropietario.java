/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Excepcion.DatoInvalidoExcepcion;
import controlador.PropietarioControlador;
import dto.PropietarioDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class FormPropietario extends JFrame {

    private JTextField txtNombre, txtCedula, txtDireccion, txtTelefono;
    private JTable tablaPropietarios;
    private DefaultTableModel modeloTabla;

    private final PropietarioControlador controlador = new PropietarioControlador();

    public FormPropietario() {
        setTitle("Gestión de Propietarios");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
        cargarPropietarios();
    }

    private void initUI() {
        JPanel panelFormulario = new JPanel(new GridLayout(7, 5, 7, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Registrar Propietario"));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelFormulario.add(txtCedula);

        panelFormulario.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelFormulario.add(txtTelefono);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrarPropietario());
        panelFormulario.add(btnRegistrar);

        JButton btnActualizarPropietario = new JButton("Actualizar");
        btnActualizarPropietario.addActionListener(e -> actualizarPropietario());
        panelFormulario.add(btnActualizarPropietario);

        JButton btnEliminar = new JButton("Eliminar Seleccionado");
        btnEliminar.addActionListener(e -> eliminarPropietarioSeleccionado());
        panelFormulario.add(btnEliminar);

        JButton btnActualizar = new JButton("Actualizar Lista");
        btnActualizar.addActionListener(e -> cargarPropietarios());
        panelFormulario.add(btnActualizar);

        add(panelFormulario, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Cédula", "Dirección", "Teléfono"}, 0);
        tablaPropietarios = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaPropietarios);
        scroll.setBorder(BorderFactory.createTitledBorder("Propietarios Registrados"));

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

    private void registrarPropietario() {
        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String telefono = txtTelefono.getText().trim();

        try {
            controlador.registrarPropietario(nombre, cedula, direccion, telefono);
            JOptionPane.showMessageDialog(this, "Propietario registrado exitosamente.");
            limpiarCampos();
            cargarPropietarios();
        } catch (DatoInvalidoExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarPropietario() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del propietario a actualizar:");
        if (id == null || id.trim().isEmpty()) {
            return;
        }

        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String telefono = txtTelefono.getText().trim();

        try {
            controlador.actualizarPropietario(id.trim(), nombre, cedula, direccion, telefono);
            JOptionPane.showMessageDialog(this, "Propietario actualizado exitosamente.");
            limpiarCampos();
            cargarPropietarios();
        } catch (DatoInvalidoExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarPropietarioSeleccionado() {
        int fila = tablaPropietarios.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un propietario de la tabla para eliminar.");
            return;
        }

        String id = modeloTabla.getValueAt(fila, 0).toString();
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar al propietario con ID " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                controlador.eliminarPropietario(id);
                JOptionPane.showMessageDialog(this, "Propietario eliminado.");
                cargarPropietarios();
            } catch (DatoInvalidoExcepcion e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }

    private void cargarPropietarios() {
        modeloTabla.setRowCount(0);
        List<PropietarioDTO> lista = controlador.listarPropietarios();
        for (PropietarioDTO p : lista) {
            modeloTabla.addRow(new Object[]{
                p.getId(), p.getNombre(), p.getCedula(), p.getDireccion(), p.getTelefono()
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
            java.util.logging.Logger.getLogger(FormPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPropietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
