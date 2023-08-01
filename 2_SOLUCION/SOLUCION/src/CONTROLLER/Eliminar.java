package CONTROLLER;

import MODEL.ConexionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eliminar {
    private JPanel panelPrincipal;
    private JButton eliminarCuentaButton;
    private JButton eliminarPlanesButton;
    private JButton btn_cerrar;
    private JFrame jFrame;

    public Eliminar() {
        eliminarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConexionDB().eliminarCliente(new GestionPlanes().getClienteActual().cedula);
                jFrame.dispose();
            }
        });
        eliminarPlanesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionDB conexionDB = new ConexionDB();
                String cedula = new GestionPlanes().getClienteActual().cedula;
                conexionDB.eliminarPlanPostPagoMinutosMegas(cedula);
                conexionDB.eliminarPlanPostPagoMinutos(cedula);
                conexionDB.eliminarPlanPostPagoMinutosMegasEconomico(cedula);
                conexionDB.eliminarPlanPostPagoMegas(cedula);
                jFrame.dispose();
            }
        });
        btn_cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("Agregar Plan2");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
