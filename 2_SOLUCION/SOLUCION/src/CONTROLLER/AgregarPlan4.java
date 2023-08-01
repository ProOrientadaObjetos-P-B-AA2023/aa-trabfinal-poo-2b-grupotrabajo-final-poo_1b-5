package CONTROLLER;

import MODEL.ConexionDB;
import MODEL.PlanPostPagoMinutosMegasEconomico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarPlan4 {
    private JPanel panelPrincipal;
    private JButton OKButton;
    private JTextField txt_minutos;
    private JButton btn_cerrar;
    private JTextField txt_costoMinutos;
    private JTextField txt_megasExpresadosGigas;
    private JTextField txt_costoPorCadaGiga;
    private JLabel lbl_minutos;
    private JLabel lbl_costoMinutos;
    private JLabel lbl_megasExpresadosGigas;
    private JLabel lbl_costoPorCadaGiga;
    private JFrame jFrame;

    public AgregarPlan4() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarLleno();
                int minutos = 0;
                double costoMinutos = 0;
                int megasExpresadosGigas = 0;
                double costoPorCadaGiga = 0;
                boolean v = true;
                if (txt_minutos.getText().equals("")) {
                    lbl_minutos.setText("Ingrese Minutos");
                    v = false;
                } else {
                    minutos = Integer.parseInt(txt_minutos.getText());
                }
                if (txt_costoMinutos.getText().equals("")) {
                    lbl_costoMinutos.setText("Ingrese Costo Minutos");
                    v = false;
                } else {
                    costoMinutos = Integer.parseInt(txt_costoMinutos.getText());
                }
                if (txt_megasExpresadosGigas.getText().equals("")) {
                    lbl_megasExpresadosGigas.setText("Ingrese Megas expresados Gigas");
                    v = false;
                } else {
                    megasExpresadosGigas = Integer.parseInt(txt_megasExpresadosGigas.getText());
                }
                if (txt_costoPorCadaGiga.getText().equals("")) {
                    lbl_costoPorCadaGiga.setText("Ingrese Costo por cada giga");
                    v = false;
                } else {
                    costoPorCadaGiga = Integer.parseInt(txt_costoPorCadaGiga.getText());
                }
                if (v) {
                    ConexionDB conexionDB = new ConexionDB();
                    conexionDB.insertarPlanPostPagoMinutosMegasEconomico(new PlanPostPagoMinutosMegasEconomico(new GestionPlanes().getClienteActual().cedula, minutos, costoMinutos, megasExpresadosGigas, costoPorCadaGiga));
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
        lbl_costoPorCadaGiga.setText("");
        lbl_costoMinutos.setText("");
        lbl_minutos.setText("");
        lbl_megasExpresadosGigas.setText("");
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("Agregar Plan2");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
