/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import Excepcion.DatoInvalidoExcepcion;
import controlador.ConsultaVeterinariaControlador;
import transferencia.ConsultaVeterinariaDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import utils.Estilo;
import vista.MenuPrincipal;
/**
 *
 * @author PEDRO LUIS MARTINEZ
 */




public class FormConsultaVeterinaria extends JFrame {

    private JTextField txtIdMascota, txtIdVeterinario, txtMotivo, txtDiagnostico, txtTratamiento, txtFiltroIdMascota;
    private JTable tablaConsultas;
    private DefaultTableModel modeloTabla;
    private JCheckBox chkVacuna;


    private final ConsultaVeterinariaControlador controlador = new ConsultaVeterinariaControlador();

    public FormConsultaVeterinaria() {
        setTitle("Consultas Veterinarias");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        Estilo.aplicarEstiloVentana(this);

        initUI();
    }

    private void initUI() {
        JPanel panelFormulario = new JPanel(new GridLayout(10, 5, 10, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Registrar Consulta"));
        Estilo.aplicarEstiloPanel(panelFormulario);


        txtIdMascota = new JTextField();
        txtIdVeterinario = new JTextField();
        txtMotivo = new JTextField();
        txtDiagnostico = new JTextField();
        txtTratamiento = new JTextField();
        
        panelFormulario.add(new JLabel("ID Mascota:"));
        panelFormulario.add(txtIdMascota);

        panelFormulario.add(new JLabel("ID Veterinario:"));
        panelFormulario.add(txtIdVeterinario);

        panelFormulario.add(new JLabel("Motivo:"));
        panelFormulario.add(txtMotivo);

        panelFormulario.add(new JLabel("Diagnóstico:"));
        panelFormulario.add(txtDiagnostico);

        panelFormulario.add(new JLabel("Tratamiento:"));
        panelFormulario.add(txtTratamiento);

        JButton btnRegistrar = new JButton("Registrar Consulta");
        btnRegistrar.addActionListener(e -> registrarConsulta());
        panelFormulario.add(btnRegistrar);

        JButton btnConsultar = new JButton("Ver Todas");
        btnConsultar.addActionListener(e -> cargarConsultas());
        panelFormulario.add(btnConsultar);
        
        JButton btnEliminar = new JButton("Eliminar Consulta");
        btnEliminar.addActionListener(e -> eliminarConsultaSeleccionada());
        panelFormulario.add(btnEliminar);
        
        chkVacuna = new JCheckBox("¿Vacuna aplicada?");
        panelFormulario.add(chkVacuna);
        
       
        add(panelFormulario, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new Object[]{
                "ID", "Fecha", "Mascota", "Veterinario", "Motivo", "Diagnóstico", "Tratamiento","Vacuna"
        }, 0);
        tablaConsultas = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaConsultas);
        scroll.setBorder(BorderFactory.createTitledBorder("Historial de Consultas"));
        add(scroll, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());

        JPanel panelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtFiltroIdMascota = new JTextField(10);
        JButton btnFiltrar = new JButton("Filtrar por ID Mascota");
        btnFiltrar.addActionListener(e -> filtrarPorMascota());

        panelFiltro.add(new JLabel("ID Mascota:"));
        panelFiltro.add(txtFiltroIdMascota);
        panelFiltro.add(btnFiltrar);

        panelInferior.add(panelFiltro, BorderLayout.WEST);

        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.addActionListener(e -> {
            dispose();
            new MenuPrincipal().setVisible(true);
        });

        JPanel panelVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelVolver.add(btnVolver);
        panelInferior.add(panelVolver, BorderLayout.EAST);

        add(panelInferior, BorderLayout.SOUTH);
    }

    
    private void eliminarConsultaSeleccionada() {
        int fila = tablaConsultas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una consulta de la tabla para eliminar.");
            return;
        }

        String id = modeloTabla.getValueAt(fila, 0).toString();
        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de eliminar la consulta con ID " + id + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                controlador.eliminarConsulta(id);
                JOptionPane.showMessageDialog(this, "Consulta eliminada exitosamente.");
                cargarConsultas();
            } catch (DatoInvalidoExcepcion ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void registrarConsulta() {
        try {
            boolean vacuna = chkVacuna.isSelected();
            controlador.registrarConsulta(
                    txtIdMascota.getText().trim(),
                    txtIdVeterinario.getText().trim(),
                    txtMotivo.getText().trim(),
                    txtDiagnostico.getText().trim(),
                    txtTratamiento.getText().trim(),
                    vacuna
                    
            );
            JOptionPane.showMessageDialog(this, "Consulta registrada exitosamente.");
            limpiarCampos();
            cargarConsultas();
        } catch (DatoInvalidoExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cargarConsultas() {
        modeloTabla.setRowCount(0);
        List<ConsultaVeterinariaDTO> lista = controlador.listarConsultas();
        for (ConsultaVeterinariaDTO c : lista) {
            modeloTabla.addRow(new Object[]{
                    c.getIdConsulta(),
                    c.getFecha(),
                    c.getIdMascota(),
                    c.getIdVeterinario(),
                    c.getMotivo(),
                    c.getDiagnostico(),
                    c.getTratamiento(),
                    c.isVacunaAplicada() ? "Si" : "No"
            });
        }
    }

    private void filtrarPorMascota() {
        String idMascota = txtFiltroIdMascota.getText().trim();
        if (idMascota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un ID de mascota para filtrar.");
            return;
        }

        modeloTabla.setRowCount(0);
        List<ConsultaVeterinariaDTO> lista = controlador.listarPorMascota(idMascota);
        for (ConsultaVeterinariaDTO c : lista) {
            modeloTabla.addRow(new Object[]{
                    c.getIdConsulta(),
                    c.getFecha(),
                    c.getIdMascota(),
                    c.getIdVeterinario(),
                    c.getMotivo(),
                    c.getDiagnostico(),
                    c.getTratamiento(),
                    c.isVacunaAplicada() ? "Si" : "No"
            });
        }

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron consultas para esa mascota.");
        }
    }

    private void limpiarCampos() {
        txtIdMascota.setText("");
        txtIdVeterinario.setText("");
        txtMotivo.setText("");
        txtDiagnostico.setText("");
        txtTratamiento.setText("");
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
            java.util.logging.Logger.getLogger(FormConsultaVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultaVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultaVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultaVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConsultaVeterinaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
