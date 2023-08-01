package CONTROLLER;

import MODEL.ConexionDB;
import MODEL.PlanPostPagoMinutosMegas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarPlan3 {
    private JButton btn_cerrar;
    private JTextField txt_MEG;
    private JTextField txt_CG;
    private JTextField txt_TB;
    private JButton btn_OK;
    private JPanel panelPrincipal;
    private JLabel lbl_errMEG;
    private JLabel lbl_errCG;
    private JLabel lbl_errTB;
    private JFrame jFrame;

    public AgregarPlan3() {
        btn_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarLleno();
                int megasExpresadosGigas = 0;
                double costoGiga = 0;
                double tarifaBase = 0;
                boolean v = true;
                if (txt_MEG.getText().equals("")) {
                    lbl_errCG.setText("Ingrese Megas expresados en gigas");
                    v = false;
                } else {
                    megasExpresadosGigas = Integer.parseInt(txt_MEG.getText());
                }

                if (txt_CG.getText().equals("")) {
                    lbl_errCG.setText("Ingrese Costo Giga");
                    v = false;
                } else {
                    costoGiga = Double.parseDouble(txt_CG.getText());
                }

                if (txt_TB.getText().equals("")) {
                    lbl_errTB.setText("Ingrese Costo Giga");
                    v = false;
                } else {
                    tarifaBase = Double.parseDouble(txt_TB.getText());
                }
                if (v) {
                    ConexionDB conexionDB = new ConexionDB();
                    conexionDB.insertarPlanPostPagoMinutosMegas(new PlanPostPagoMinutosMegas(new GestionPlanes().getClienteActual().cedula, megasExpresadosGigas, costoGiga, tarifaBase));
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
        lbl_errCG.setText("");
        lbl_errMEG.setText("");
        lbl_errTB.setText("");
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("Agregar Plan2");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
