package CONTROLLER;

import MODEL.ConexionDB;
import MODEL.PlanPostPagoMinutos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarPlan2 {
    private JPanel panelPrincipal;
    private JTextField txt_minutosNacionales;
    private JLabel lbl_errMN;
    private JLabel lbl_errCMN;
    private JLabel lbl_errMI;
    private JLabel lbl_errCMI;
    private JTextField txt_CostoMinutosNacional;
    private JTextField txt_MinutosInternacionales;
    private JTextField txt_CostoMinutoInternacional;
    private JButton btn_cerrar;
    private JButton btn_OK;
    private JFrame jFrame;

    public AgregarPlan2() {
        btn_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarLleno();
                int minutosNacionales = 0;
                double costoMinutosNacional = 0;
                int minutosInternacionales = 0;
                double costoMinutoInternacional = 0;
                boolean v = true;

                if (txt_minutosNacionales.getText().equals("")) {
                    lbl_errMN.setText("Ingrese Minutos");
                    v = false;
                } else {
                    minutosNacionales = Integer.parseInt(txt_minutosNacionales.getText());
                }

                if (txt_CostoMinutosNacional.getText().equals("")) {
                    lbl_errCMN.setText("Ingrese Minutos");
                    v = false;
                } else {
                    costoMinutosNacional = Integer.parseInt(txt_CostoMinutosNacional.getText());
                }

                if (txt_MinutosInternacionales.getText().equals("")) {
                    lbl_errMI.setText("Ingrese Minutos");
                    v = false;
                } else {
                    minutosInternacionales = Integer.parseInt(txt_MinutosInternacionales.getText());
                }

                if (txt_CostoMinutoInternacional.getText().equals("")) {
                    lbl_errCMI.setText("Ingrese Minutos");
                    v = false;
                } else {
                    costoMinutoInternacional = Integer.parseInt(txt_CostoMinutoInternacional.getText());
                }
                if (v) {
                    ConexionDB conexionDB = new ConexionDB();
                    new ConexionDB().insertarPlanPostPagoMinutos(new PlanPostPagoMinutos(new GestionPlanes().getClienteActual().cedula, minutosNacionales, costoMinutosNacional, minutosInternacionales, costoMinutoInternacional));
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
        lbl_errCMI.setText("");
        lbl_errMI.setText("");
        lbl_errCMN.setText("");
        lbl_errMN.setText("");
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("Agregar Plan2");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
