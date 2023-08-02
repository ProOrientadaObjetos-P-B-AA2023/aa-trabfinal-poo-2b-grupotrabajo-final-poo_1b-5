package CONTROLLER;

import MODEL.Cliente;
import MODEL.ConexionDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class GestionPlanes {
    public static Cliente clienteActual;
    public String[] tablaT = {"Nombre", "Cedula", "Ciudad", "Marca", "Modelo", "NumeroCelular", "PagoMensual", "TipoPersonal", "CostoMatricula", "NumeroPlanes", "Total"};
    public DefaultTableModel model = new DefaultTableModel(null, tablaT);
    private JPanel panelPrincipal;
    private JTable tbl_Clientes;
    private JButton btn_Cedula;
    private JTextField txt_Cedula;
    private JButton btn_AgregarPlan;
    private JButton btn_Eliminar;
    private JButton btn_Modificar;
    private JButton btn_AgregarCliente;
    private JButton btn_BuscarPlanes;
    private JLabel lbl_errCedula;
    private JButton btn_nuevo;
    private JButton btn_actualizar;
    private JButton btn_factura;


    public GestionPlanes() {

        tbl_Clientes.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                mostrarDatosDBCliente();
            }

        });

        btn_Cedula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_errCedula.setText("");
                boolean n = false;
                String cedula = txt_Cedula.getText();
                ArrayList<Cliente> clientes = new ConexionDB().obtenerClientes();
                for (Cliente cliente : clientes) {
                    if (cliente.cedula.equals(cedula)) {
                        btn_AgregarPlan.setEnabled(true);
                        btn_Eliminar.setEnabled(true);
                        btn_Modificar.setEnabled(true);
                        btn_BuscarPlanes.setEnabled(true);
                        txt_Cedula.setEnabled(false);
                        btn_Cedula.setEnabled(false);
                        btn_nuevo.setEnabled(true);
                        clienteActual = cliente;
                        btnFactura();
                        btnPlanes();
                        n = true;
                        break;
                    }
                }
                if (!n)
                    lbl_errCedula.setText("Cedula No Encontrada");
            }
        });

        btn_AgregarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarCliente().inciarAgregarPanel();
            }
        });
        btn_AgregarPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarPlan().inciarAgregarPanel();
            }
        });
        btn_actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosDBCliente();
                if (clienteActual!=null){
                    btnPlanes();
                    btnFactura();
                    actualizarClienteActual();
                }
            }
        });
        btn_Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Eliminar().inciarAgregarPanel();
            }
        });
        btn_BuscarPlanes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Planes().inciarAgregarPanel();
            }
        });
        btn_Modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Modificar().inciarAgregarPanel();
                txt_Cedula.setText("");
            }
        });
        btn_nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_AgregarPlan.setEnabled(false);
                btn_Eliminar.setEnabled(false);
                btn_Modificar.setEnabled(false);
                btn_BuscarPlanes.setEnabled(false);
                txt_Cedula.setEnabled(true);
                btn_Cedula.setEnabled(true);
                txt_Cedula.setText("");
            }
        });
        btn_factura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Factura().inciarAgregarPanel();
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("asd");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setContentPane(new GestionPlanes().panelPrincipal);
        jFrame.setVisible(true);
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setCliente(Cliente cliente) {
        clienteActual = cliente;
    }

    public void mostrarDatosDBCliente() {
        ArrayList<Cliente> clientes = new ConexionDB().obtenerClientes();
        String[][] datos = new String[clientes.size()][11];
        for (int i = 0; i < clientes.size(); i++) {
            datos[i][0] = clientes.get(i).nombre;
            datos[i][1] = clientes.get(i).cedula;
            datos[i][2] = clientes.get(i).ciudad;
            datos[i][3] = clientes.get(i).marca;
            datos[i][4] = clientes.get(i).modelo;
            datos[i][5] = clientes.get(i).numeroCelular;
            datos[i][6] = String.valueOf(clientes.get(i).pagoMensual);
            datos[i][7] = clientes.get(i).tipoPersonal;
            datos[i][8] = String.valueOf(clientes.get(i).costoMatricula);
            datos[i][9] = String.valueOf(clientes.get(i).nPlanes);
            datos[i][10] = String.valueOf(clientes.get(i).total);
        }
        model.setDataVector(datos, tablaT);
        tbl_Clientes.setModel(model);
    }

    public void btnFactura() {
        btn_factura.setEnabled(clienteActual.nPlanes > 0);
    }

    public void btnPlanes() {
        btn_AgregarPlan.setEnabled(clienteActual.nPlanes != 2);
    }

    public void actualizarClienteActual() {
        clienteActual = new ConexionDB().actualizarCliente(clienteActual.cedula);
    }
}
