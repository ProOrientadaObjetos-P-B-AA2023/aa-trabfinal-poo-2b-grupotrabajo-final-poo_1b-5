package MODEL;

import CONTROLLER.CalcularTotal;

public class Cliente {
    public String nombre;
    public String cedula;
    public String ciudad;
    public String marca;
    public String modelo;
    public String numeroCelular;
    public double pagoMensual;
    public String tipoPersonal;
    public double costoMatricula;
    public int nPlanes;
    public double total;

    public Cliente(String nombre, String cedula, String ciudad, String marca, String modelo, String numeroCelular, double pagoMensual, String tipoPersonal, double costoMatricula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCelular = numeroCelular;
        this.pagoMensual = pagoMensual;
        this.tipoPersonal = tipoPersonal;
        this.costoMatricula = costoMatricula;
    }

    public Cliente() {
    }

    public int establecerTotalPlanes() {
        nPlanes = new ConexionDB().totalPlanes(cedula).size();
        return nPlanes;
    }

    public double establecerTotal() {
        total = new CalcularTotal().total(new ConexionDB().totalPlanes(cedula));
        return total;
    }

    public void establecerDBTotal(double total) {
        this.total = establecerTotal();
    }

    public void establecerDBNTotalPlanes(int nPlanes) {
        this.nPlanes = establecerTotalPlanes();
    }

    public String toString() {
        return String.format("Nombre: %s%nCedula: %s%nCiudad: %s%n" +
                        "Marca: %s%nModelo: %s%nNumero de Celular: %s%n" +
                        "Pago Mensual: %.2f%nTipo Personal: %s%n",
                nombre, cedula, ciudad, marca, modelo, numeroCelular, pagoMensual, tipoPersonal);
    }
}
