package CONTROLLER;


import MODEL.Cliente;
import MODEL.ConexionDB;
import MODEL.Plan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class Factura {

    private final String[] cabeceraTBL = {"Plan N.-", "Subtotal"};
    DefaultTableModel model = new DefaultTableModel();
    private JPanel panelPrincipal;
    private JLabel lbl_Cedula;
    private JTable tbl_Planes;
    private JLabel lbl_Total;
    private JLabel lbl_Cliente;
    private JLabel lbl_NumeroCelular;
    private JLabel lbl_NPlanes;
    private JButton btn_cerrar;
    private JFrame jFrame;

    public Factura() {
        tbl_Planes.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Cliente cliente = new GestionPlanes().getClienteActual();
                ArrayList<Plan> planes = new ConexionDB().totalPlanes(new GestionPlanes().getClienteActual().cedula);
                String[][] datos = new String[planes.size()][2];
                for (int i = 0; i < planes.size(); i++) {
                    datos[i][0] = String.valueOf(i + 1);
                    datos[i][1] = String.valueOf(planes.get(i).calcularTotal());
                }
                model.setDataVector(datos, cabeceraTBL);
                tbl_Planes.setModel(model);
                lbl_Cedula.setText(cliente.cedula);
                lbl_Cliente.setText(cliente.nombre);
                lbl_NPlanes.setText(String.valueOf(cliente.nPlanes));
                lbl_Total.setText(String.valueOf(cliente.total));
                lbl_NumeroCelular.setText(cliente.numeroCelular);
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
