package CONTROLLER;

import MODEL.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class Planes {
    public String[] dt1 = {"Cedula", "Minutos", "CostoMinutos", "MegaEnGigas", "CostoGigas", "PorcentajeDescuento", "SubTotal"};
    public String[] dt2 = {"Cedula", "MinutosNacionales", "CostoMinutosNacional", "MinutosInternacional", "CostoMinutoInternacional", "SubTotal"};
    public String[] dt3 = {"Cedula", "MegasExpresadoGigas", "CostoGiga", "TarifaBase", "SubTotal"};
    public String[] dt4 = {"Cedula", "Minutos", "CostoMinutos", "MegasExpresadosGigas", "CostoPorCadaGiga", "SubTotal"};
    public DefaultTableModel model = new DefaultTableModel(null, dt1);
    public DefaultTableModel model2 = new DefaultTableModel(null, dt2);
    public DefaultTableModel model3 = new DefaultTableModel(null, dt3);
    public DefaultTableModel model4 = new DefaultTableModel(null, dt4);
    private JPanel panelPrincipal;
    private JTable tbl_PPPM;
    private JButton btn_cerrar;
    private JTable tbl_PPPM1;
    private JTable tbl_PPPMM;
    private JTable tbl_PPPMME;
    private JButton btn_elmPPM;
    private JButton btn_elmPPM2;
    private JButton btn_elmPPMM;
    private JButton btn_elmPPMME;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JFrame jFrame;

    public Planes() {
        btn_cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        tbl_PPPM.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                mostrarTB1();
                mostrarTB2();
                mostrarTB3();
                mostrarTB4();
            }
        });
        btn_elmPPM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConexionDB().eliminarPlanPostPagoMegas(new GestionPlanes().getClienteActual().cedula);
                mostrarTB1();
            }
        });
        btn_elmPPM2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConexionDB().eliminarPlanPostPagoMinutos(new GestionPlanes().getClienteActual().cedula);
                mostrarTB2();
            }
        });
        btn_elmPPMM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConexionDB().eliminarPlanPostPagoMinutosMegas(new GestionPlanes().getClienteActual().cedula);
                mostrarTB3();
            }
        });
        btn_elmPPMME.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConexionDB().eliminarPlanPostPagoMinutosMegasEconomico(new GestionPlanes().getClienteActual().cedula);
                mostrarTB4();
            }
        });
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("EliminarPanel");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void mostrarTB1() {
        try {
            ArrayList<PlanPostPagoMegas> plans = new ConexionDB().planPPPM(new GestionPlanes().getClienteActual().cedula);
            String[][] datos = new String[plans.size()][7];
            for (int i = 0; i < plans.size(); i++) {
                datos[i][0] = plans.get(i).cedula;
                datos[i][1] = String.valueOf(plans.get(i).minutos);
                datos[i][2] = String.valueOf(plans.get(i).costoMinutos);
                datos[i][3] = String.valueOf(plans.get(i).megasEnGigas);
                datos[i][4] = String.valueOf(plans.get(i).costoGigas);
                datos[i][5] = String.valueOf(plans.get(i).porcentajeDescuento);
                datos[i][6] = String.valueOf(plans.get(i).calcularTotal());
            }
            model.setDataVector(datos, dt1);
            tbl_PPPM.setModel(model);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void mostrarTB2() {
        try {
            ArrayList<PlanPostPagoMinutos> plans = new ConexionDB().planPPPM1(new GestionPlanes().getClienteActual().cedula);
            String[][] datos = new String[plans.size()][6];
            for (int i = 0; i < plans.size(); i++) {
                datos[i][0] = plans.get(i).cedula;
                datos[i][1] = String.valueOf(plans.get(i).minutosNacionales);
                datos[i][2] = String.valueOf(plans.get(i).costoMinutosNacional);
                datos[i][3] = String.valueOf(plans.get(i).minutosInternacionales);
                datos[i][4] = String.valueOf(plans.get(i).costoMinutoInternacional);
                datos[i][5] = String.valueOf(plans.get(i).calcularTotal());
            }
            model2.setDataVector(datos, dt2);
            tbl_PPPM1.setModel(model2);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void mostrarTB3() {
        try {
            ArrayList<PlanPostPagoMinutosMegas> plans = new ConexionDB().PPPMM(new GestionPlanes().getClienteActual().cedula);
            String[][] datos = new String[plans.size()][5];
            DefaultTableModel model = new DefaultTableModel();
            for (int i = 0; i < plans.size(); i++) {
                datos[i][0] = plans.get(i).cedula;
                datos[i][1] = String.valueOf(plans.get(i).megasExpresadosGigas);
                datos[i][2] = String.valueOf(plans.get(i).costoGiga);
                datos[i][3] = String.valueOf(plans.get(i).tarifaBase);
                datos[i][4] = String.valueOf(plans.get(i).calcularTotal());
            }
            model3.setDataVector(datos, dt3);
            tbl_PPPMM.setModel(model3);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void mostrarTB4() {
        try {
            ArrayList<PlanPostPagoMinutosMegasEconomico> plans = new ConexionDB().PPPMME(new GestionPlanes().getClienteActual().cedula);
            String[][] datos = new String[plans.size()][6];
            for (int i = 0; i < plans.size(); i++) {
                datos[i][0] = plans.get(i).cedula;
                datos[i][1] = String.valueOf(plans.get(i).minutos);
                datos[i][2] = String.valueOf(plans.get(i).costoMinutos);
                datos[i][3] = String.valueOf(plans.get(i).megasExpresadosGigas);
                datos[i][4] = String.valueOf(plans.get(i).costoPorCadaGiga);
                datos[i][5] = String.valueOf(plans.get(i).calcularTotal());
            }
            model4.setDataVector(datos, dt4);
            tbl_PPPMME.setModel(model4);
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}
