package CONTROLLER;

import MODEL.Cliente;
import MODEL.ConexionDB;

import java.util.ArrayList;

public class app {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes= new ConexionDB().obtenerClientes();
        System.out.println(clientes);
    }
}
