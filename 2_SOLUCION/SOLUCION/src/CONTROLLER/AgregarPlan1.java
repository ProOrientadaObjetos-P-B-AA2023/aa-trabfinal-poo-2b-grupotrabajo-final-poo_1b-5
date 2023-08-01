package CONTROLLER;

import MODEL.ConexionDB;
import MODEL.PlanPostPagoMegas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarPlan1 {
    private JPanel panelPrincipal;
    private JTextField txt_minutos;
    private JButton btn_OK;
    private JTextField txt_costoMinutos;
    private JTextField txt_megasEnGigas;
    private JTextField txt_costoGigas;
    private JTextField txt_porcentajeDescuento;
    private JLabel lbl_errMinutos;
    private JLabel lbl_errCostoMinutos;
    private JLabel lbl_errMegasEnGigas;
    private JLabel lbl_errCostoGigas;
    private JLabel lbl_errPorcentajeDescuento;
    private JButton btn_cerrar;
    private JFrame jFrame;

    public AgregarPlan1() {
        btn_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarLleno();
                int minutos = 0;
                double costoMinutos = 0;
                double megasEnGigas = 0;
                double costoGigas = 0;
                double porcentajeDescuento = 0;
                boolean v = true;
                if (txt_minutos.getText().equals("")) {
                    lbl_errMinutos.setText("Ingrese Minutos");
                    v = false;
                } else {
                    minutos = Integer.parseInt(txt_minutos.getText());
                }
                if (txt_costoMinutos.getText().equals("")) {
                    lbl_errCostoMinutos.setText("Ingrese CostoMinutos");
                    v = false;
                } else {
                    costoMinutos = Double.parseDouble(txt_costoMinutos.getText());
                }
                if (txt_megasEnGigas.getText().equals("")) {
                    lbl_errMegasEnGigas.setText("Ingrese MegasEnGigas");
                    v = false;
                } else {
                    megasEnGigas = Double.parseDouble(txt_costoGigas.getText());
                }
                if (txt_costoGigas.getText().equals("")) {
                    lbl_errCostoGigas.setText("Ingrese CostoGigas");
                    v = false;
                } else {
                    costoGigas = Double.parseDouble(txt_costoGigas.getText());
                }
                if (txt_porcentajeDescuento.getText().equals("")) {
                    lbl_errPorcentajeDescuento.setText("Ingrese PorcentajeDescuento");
                    v = false;
                } else {
                    porcentajeDescuento = Double.parseDouble(txt_porcentajeDescuento.getText());
                }
                if (v) {
                    ConexionDB conexionDB = new ConexionDB();
                    conexionDB.insertarPlanPostPagoMegas(new PlanPostPagoMegas(new GestionPlanes().getClienteActual().cedula, minutos, costoMinutos, megasEnGigas, costoGigas, porcentajeDescuento));
                    new ConexionDB().actualizardtC(new GestionPlanes().getClienteActual());
                    jFrame.dispose();
                }
            }
        });
        btn_cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
    }

    public void vaciarLleno() {
        lbl_errCostoGigas.setText("");
        lbl_errCostoMinutos.setText("");
        lbl_errMinutos.setText("");
        lbl_errPorcentajeDescuento.setText("");
        lbl_errMegasEnGigas.setText("");
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("Agregar Plan1");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
