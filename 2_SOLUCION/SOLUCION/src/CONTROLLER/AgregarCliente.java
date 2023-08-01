package CONTROLLER;

import MODEL.Cliente;
import MODEL.ConexionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarCliente {
    private JPanel panelPrincipal;
    private JTextField txt_nombre;
    private JTextField txt_cedula;
    private JTextField txt_ciudad;
    private JTextField txt_Marca;
    private JTextField txt_modelo;
    private JTextField txt_numeroContacto;
    private JTextField txt_PagoMensual;
    private JTextField txt_tipoPersonal;
    private JTextField txt_CostoMatricula;
    private JButton OKButton;
    private JLabel lbl_errNombre;
    private JLabel lbl_errCedula;
    private JLabel lbl_errCiudad;
    private JLabel lbl_errMarca;
    private JLabel lbl_errModelo;
    private JLabel lbl_errNumeroContacto;
    private JLabel lbl_errPagoMensual;
    private JLabel lbl_errTipoPersonal;
    private JLabel lbl_errCostoMatricula;

    private JFrame jFrame;

    public AgregarCliente() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarLleno();
                String nombre = "";
                String cedula = "";
                String ciudad = "";
                String marca= "";
                String modelo = "";
                String numeroCelular = "";
                double pagoMensual = 0;
                String tipoPersonal = "";
                double costoMatricula = 0;
                boolean v = true;
                if (txt_nombre.getText().equals("")) {
                    lbl_errNombre.setText("Ingrese Nombre");
                    v = false;
                } else {
                    nombre = txt_nombre.getText();
                }
                if (txt_cedula.getText().equals("")) {
                    lbl_errCedula.setText("Ingrese Cedula");
                    v = false;
                } else {
                    cedula = txt_cedula.getText();
                }

                if (txt_ciudad.getText().equals("")) {
                    lbl_errCiudad.setText("Ingrese Ciudad");
                    v = false;
                } else {
                    ciudad = txt_ciudad.getText();
                }

                if (txt_Marca.getText().equals("")) {
                    lbl_errMarca.setText("Ingrese Marca");
                    v = false;
                } else {
                    marca = txt_Marca.getText();
                }
                if (txt_modelo.getText().equals("")) {
                    lbl_errModelo.setText("Ingrese Modelo");
                    v = false;
                } else {
                    modelo = txt_modelo.getText();
                }

                if (txt_numeroContacto.getText().equals("")) {
                    lbl_errNumeroContacto.setText("Ingrese Numero De Contacto");
                    v = false;
                } else {
                    numeroCelular = txt_numeroContacto.getText();
                }
                if (txt_PagoMensual.getText().equals("")) {
                    lbl_errPagoMensual.setText("Ingrese Pago Mensual");
                    v = false;
                } else {
                    pagoMensual = Double.parseDouble(txt_PagoMensual.getText());
                }
                if (txt_tipoPersonal.getText().equals("")) {
                    lbl_errTipoPersonal.setText("Ingrese Tipo Personal");
                    v = false;
                } else {
                    tipoPersonal = txt_tipoPersonal.getText();
                }
                if (txt_CostoMatricula.getText().equals("")) {
                    lbl_errCostoMatricula.setText("Ingrese Costo Matricula");
                    v = false;
                } else {
                    costoMatricula = Double.parseDouble(txt_CostoMatricula.getText());
                }
                if (v) {
                    ConexionDB conexionDB = new ConexionDB();
                    conexionDB.insertarCliente(new Cliente(nombre, cedula, ciudad, marca, modelo, numeroCelular, pagoMensual, tipoPersonal, costoMatricula));
                    jFrame.dispose();
                }
            }
        });
    }

    public void vaciarLleno() {
        lbl_errNombre.setText("");
        lbl_errCedula.setText("");
        lbl_errCiudad.setText("");
        lbl_errMarca.setText("");
        lbl_errModelo.setText("");
        lbl_errNumeroContacto.setText("");
        lbl_errPagoMensual.setText("");
        lbl_errTipoPersonal.setText("");
        lbl_errCostoMatricula.setText("");
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("Agregar");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
