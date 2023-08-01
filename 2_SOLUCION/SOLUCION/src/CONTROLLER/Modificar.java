package CONTROLLER;

import MODEL.Cliente;
import MODEL.ConexionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Modificar {
    JFrame jFrame;
    private JPanel panelPrincipal;
    private JTextField txt_nombre;
    private JButton modificarButton;
    private JTextField txt_cedula;
    private JTextField txt_ciudad;
    private JTextField txt_modelo;
    private JTextField txt_numeroCelular;
    private JTextField txt_pagoMensual;
    private JTextField txt_tipoPersonal;
    private JTextField txt_CostoMatricula;
    private JTextField txt_marca;

    public Modificar() {
        txt_cedula.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Cliente cliente = new GestionPlanes().getClienteActual();
                txt_cedula.setText(cliente.cedula);
                txt_ciudad.setText(cliente.ciudad);
                txt_nombre.setText(cliente.nombre);
                txt_modelo.setText(cliente.modelo);
                txt_marca.setText(cliente.marca);
                txt_numeroCelular.setText(cliente.numeroCelular);
                txt_pagoMensual.setText(String.valueOf(cliente.pagoMensual));
                txt_tipoPersonal.setText(cliente.tipoPersonal);
                txt_CostoMatricula.setText(String.valueOf(cliente.costoMatricula));
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txt_nombre.getText();
                String cedula = txt_cedula.getText();
                String ciudad = txt_ciudad.getText();
                String marca = txt_marca.getText();
                String modelo = txt_modelo.getText();
                String numeroCell = txt_numeroCelular.getText();
                double pagoM = Double.parseDouble(txt_pagoMensual.getText());
                String tipoPersonal = txt_tipoPersonal.getText();
                double costoMatricula = Double.parseDouble(txt_CostoMatricula.getText());
                Cliente cliente = new Cliente(nombre, cedula, ciudad, marca, modelo, numeroCell, pagoM, tipoPersonal, costoMatricula);
                new GestionPlanes().actualizarClienteActual();
                System.out.println(cliente);
                new ConexionDB().actualizarCliente(cliente);
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
