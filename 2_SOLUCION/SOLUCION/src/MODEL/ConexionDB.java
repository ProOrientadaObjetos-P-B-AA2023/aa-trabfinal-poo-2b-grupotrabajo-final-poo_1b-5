package MODEL;

import java.sql.*;
import java.util.ArrayList;

public class ConexionDB {
    public Connection concDB;
    public String msj;

    public ConexionDB() {
        try {
            setConcDB("jdbc:sqlite:2_SOLUCION/SOLUCION/bd/DB_Planes.db");
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void setConcDB(String url) throws SQLException {
        this.concDB = DriverManager.getConnection(url);
    }

    private void executePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public String insertarPlanPostPagoMinutosMegasEconomico(PlanPostPagoMinutosMegasEconomico plan) {
        try {
            String strInsertEst = "INSERT INTO PlanPostPagoMinutosMegasEconomico(Cedula, Minutos, CostoMinutos, MegasExpresadosGigas, CostoPorCadaGiga, SubTotal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = concDB.prepareStatement(strInsertEst);
            preparedStatement.setString(1, plan.cedula);
            preparedStatement.setInt(2, plan.minutos);
            preparedStatement.setDouble(3, plan.costoMinutos);
            preparedStatement.setInt(4, plan.megasExpresadosGigas);
            preparedStatement.setDouble(5, plan.costoPorCadaGiga);
            preparedStatement.setDouble(6, plan.calcularTotal());
            executePreparedStatement(preparedStatement);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return msj;
    }

    public String insertarPlanPostPagoMegas(PlanPostPagoMegas plan) {
        try {
            String strInsertEst = "INSERT INTO PlanPostPagoMegas(Cedula, Minutos, CostoMinutos, MegasEnGigas, CostoGigas, PorcentajeDescuento, SubTotal) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = concDB.prepareStatement(strInsertEst);
            preparedStatement.setString(1, plan.cedula);
            preparedStatement.setInt(2, plan.minutos);
            preparedStatement.setDouble(3, plan.costoMinutos);
            preparedStatement.setDouble(4, plan.megasEnGigas);
            preparedStatement.setDouble(5, plan.costoGigas);
            preparedStatement.setDouble(6, plan.porcentajeDescuento);
            preparedStatement.setDouble(7, plan.calcularTotal());
            executePreparedStatement(preparedStatement);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return msj;
    }

    public String insertarPlanPostPagoMinutosMegas(PlanPostPagoMinutosMegas plan) {
        try {
            String strInsertEst = "INSERT INTO PlanPostPagoMinutosMegas(Cedula, MegasExpresadosGigas, CostoGiga, TarifaBase, SubTotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = concDB.prepareStatement(strInsertEst);
            preparedStatement.setString(1, plan.cedula);
            preparedStatement.setInt(2, plan.megasExpresadosGigas);
            preparedStatement.setDouble(3, plan.costoGiga);
            preparedStatement.setDouble(4, plan.tarifaBase);
            preparedStatement.setDouble(5, plan.calcularTotal());
            executePreparedStatement(preparedStatement);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return msj;
    }

    public String insertarPlanPostPagoMinutos(PlanPostPagoMinutos plan) {
        try {
            String strInsertEst = "INSERT INTO PlanPostPagoMinutos(Cedula, MinutosNacionales, CostoMinutosNacional, MinutosInternacionales, CostoMinutoInternacional, SubTotal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = concDB.prepareStatement(strInsertEst);
            preparedStatement.setString(1, plan.cedula);
            preparedStatement.setInt(2, plan.minutosNacionales);
            preparedStatement.setDouble(3, plan.costoMinutosNacional);
            preparedStatement.setInt(4, plan.minutosInternacionales);
            preparedStatement.setDouble(5, plan.costoMinutoInternacional);
            preparedStatement.setDouble(6, plan.calcularTotal());
            executePreparedStatement(preparedStatement);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return msj;
    }

    public void actualizardtC(Cliente cliente) {
        try {
            String strAct = "UPDATE Cliente SET numeroPlanes = ?, total = ? WHERE cedula = ?";
            PreparedStatement preparedStatement = concDB.prepareStatement(strAct);
            preparedStatement.setInt(1, cliente.establecerTotalPlanes());
            preparedStatement.setDouble(2, cliente.establecerTotal());
            preparedStatement.setString(3, cliente.cedula);
            executePreparedStatement(preparedStatement);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public String actualizarCliente(Cliente cliente) {
        try {
            String strActl = "UPDATE Cliente SET nombre = ?, ciudad = ?, marca = ?, modelo = ?, numeroCelular = ?, pagoMensual = ?, tipoPersonal = ?, costoMatricula = ? WHERE cedula = ?";
            PreparedStatement preparedStatement = concDB.prepareStatement(strActl);
            preparedStatement.setString(1, cliente.nombre);
            preparedStatement.setString(2, cliente.ciudad);
            preparedStatement.setString(3, cliente.marca);
            preparedStatement.setString(4, cliente.modelo);
            preparedStatement.setString(5, cliente.numeroCelular);
            preparedStatement.setDouble(6, cliente.pagoMensual);
            preparedStatement.setString(7, cliente.tipoPersonal);
            preparedStatement.setDouble(8, cliente.costoMatricula);
            preparedStatement.setString(9, cliente.cedula);
            executePreparedStatement(preparedStatement);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return msj;
    }

    public String insertarCliente(Cliente cliente) {
        try {
            cliente.establecerTotalPlanes();
            cliente.establecerTotal();
            String strInsertEst = "INSERT INTO Cliente(nombre, cedula, ciudad, marca, modelo, numeroCelular, pagoMensual, tipoPersonal, costoMatricula, numeroPlanes, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = concDB.prepareStatement(strInsertEst);
            preparedStatement.setString(1, cliente.nombre);
            preparedStatement.setString(2, cliente.cedula);
            preparedStatement.setString(3, cliente.ciudad);
            preparedStatement.setString(4, cliente.marca);
            preparedStatement.setString(5, cliente.modelo);
            preparedStatement.setString(6, cliente.numeroCelular);
            preparedStatement.setString(7, String.valueOf(cliente.pagoMensual));
            preparedStatement.setString(8, cliente.tipoPersonal);
            preparedStatement.setString(9, String.valueOf(cliente.costoMatricula));
            preparedStatement.setString(10, String.valueOf(cliente.establecerTotalPlanes()));
            preparedStatement.setString(11, String.valueOf(cliente.establecerTotal()));
            executePreparedStatement(preparedStatement);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return msj;
    }

    public void eliminarCliente(String cedula) {
        try {
            String strDeleteEst = "DELETE FROM Cliente WHERE cedula=?";
            PreparedStatement preparedStatement = concDB.prepareStatement(strDeleteEst);
            preparedStatement.setString(1, cedula);
            preparedStatement.executeUpdate();

            eliminarPlanPostPagoMegas(cedula);
            eliminarPlanPostPagoMinutos(cedula);
            eliminarPlanPostPagoMinutosMegas(cedula);
            eliminarPlanPostPagoMinutosMegasEconomico(cedula);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void eliminarPlanPostPagoMegas(String cedula) {
        try {
            Statement statement = concDB.createStatement();
            String strDeleteEst = "DELETE FROM PlanPostPagoMegas WHERE cedula='" + cedula + "'";
            statement.executeUpdate(strDeleteEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void eliminarPlanPostPagoMinutos(String cedula) {
        try {
            Statement statement = concDB.createStatement();
            String strDeleteEst = "DELETE FROM PlanPostPagoMinutos WHERE cedula='" + cedula + "'";
            statement.executeUpdate(strDeleteEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void eliminarPlanPostPagoMinutosMegas(String cedula) {
        try {
            Statement statement = concDB.createStatement();
            String strDeleteEst = "DELETE FROM PlanPostPagoMinutosMegas WHERE cedula='" + cedula + "'";
            statement.executeUpdate(strDeleteEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void eliminarPlanPostPagoMinutosMegasEconomico(String cedula) {
        try {
            Statement statement = concDB.createStatement();
            String strDeleteEst = "DELETE FROM PlanPostPagoMinutosMegasEconomico WHERE cedula='" + cedula + "'";
            statement.executeUpdate(strDeleteEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public ArrayList<PlanPostPagoMegas> planPPPM(String cedula) {
        ArrayList<PlanPostPagoMegas> planes = new ArrayList<>();
        try {
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PlanPostPagoMegas");
            while (resultSet.next()) {
                String ced = resultSet.getString("Cedula");
                if (ced.equals(cedula)) {
                    planes.add(new PlanPostPagoMegas(cedula, resultSet.getInt("Minutos"), resultSet.getDouble("CostoMinutos"),
                            resultSet.getDouble("MegasEnGigas"), resultSet.getDouble("CostoGigas"), resultSet.getDouble("PorcentajeDescuento")));
                }
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return planes;
    }

    public ArrayList<PlanPostPagoMinutos> planPPPM1(String cedula) {
        ArrayList<PlanPostPagoMinutos> planes = new ArrayList<>();
        try {
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PlanPostPagoMinutos");
            while (resultSet.next()) {
                if (resultSet.getString("Cedula").equals(cedula)) {
                    planes.add(new PlanPostPagoMinutos(cedula, resultSet.getInt("MinutosNacionales"), resultSet.getDouble("CostoMinutosNacional"),
                            resultSet.getInt("MinutosInternacionales"), resultSet.getDouble("CostoMinutoInternacional")));
                }
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return planes;
    }

    public ArrayList<PlanPostPagoMinutosMegas> PPPMM(String cedula) {
        ArrayList<PlanPostPagoMinutosMegas> planes = new ArrayList<>();
        try {
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PlanPostPagoMinutosMegas");
            while (resultSet.next()) {
                if (resultSet.getString("Cedula").equals(cedula)) {
                    planes.add(new PlanPostPagoMinutosMegas(cedula, resultSet.getInt("MegasExpresadosGigas"), resultSet.getDouble("CostoGiga"),
                            resultSet.getDouble("TarifaBase")));
                }
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return planes;
    }


    public ArrayList<PlanPostPagoMinutosMegasEconomico> PPPMME(String cedula) {
        ArrayList<PlanPostPagoMinutosMegasEconomico> planes = new ArrayList<>();
        try {
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PlanPostPagoMinutosMegasEconomico");
            while (resultSet.next()) {
                if (resultSet.getString("Cedula").equals(cedula)) {
                    planes.add(new PlanPostPagoMinutosMegasEconomico(cedula, resultSet.getInt("Minutos"), resultSet.getDouble("CostoMinutos"),
                            resultSet.getInt("MegasExpresadosGigas"), resultSet.getDouble("CostoPorCadaGiga")));
                }
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return planes;
    }

    public ArrayList<Plan> totalPlanes(String cedula) {
        ArrayList<Plan> planes = new ArrayList<>();
        try {
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PlanPostPagoMegas");
            while (resultSet.next()) {
                String ced = resultSet.getString("Cedula");
                if (ced.equals(cedula)) {
                    planes.add(new PlanPostPagoMegas(cedula, resultSet.getInt("Minutos"), resultSet.getDouble("CostoMinutos"),
                            resultSet.getDouble("MegasEnGigas"), resultSet.getDouble("CostoGigas"), resultSet.getDouble("PorcentajeDescuento")));
                }
            }
            resultSet = statement.executeQuery("select * from PlanPostPagoMinutos");
            while (resultSet.next()) {
                if (resultSet.getString("Cedula").equals(cedula)) {
                    planes.add(new PlanPostPagoMinutos(cedula, resultSet.getInt("MinutosNacionales"), resultSet.getDouble("CostoMinutosNacional"),
                            resultSet.getInt("MinutosInternacionales"), resultSet.getDouble("CostoMinutoInternacional")));
                }
            }
            resultSet = statement.executeQuery("select * from PlanPostPagoMinutosMegas");
            while (resultSet.next()) {
                if (resultSet.getString("Cedula").equals(cedula)) {
                    planes.add(new PlanPostPagoMinutosMegas(cedula, resultSet.getInt("MegasExpresadosGigas"), resultSet.getDouble("CostoGiga"),
                            resultSet.getDouble("TarifaBase")));
                }
            }
            resultSet = statement.executeQuery("select * from PlanPostPagoMinutosMegasEconomico");
            while (resultSet.next()) {
                if (resultSet.getString("Cedula").equals(cedula)) {
                    planes.add(new PlanPostPagoMinutosMegasEconomico(cedula, resultSet.getInt("Minutos"), resultSet.getDouble("CostoMinutos"),
                            resultSet.getInt("MegasExpresadosGigas"), resultSet.getDouble("CostoPorCadaGiga")));
                }
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return planes;
    }

    public ArrayList<Cliente> obtenerClientes(){
        ArrayList<Cliente> clientes= new ArrayList<>();
        try {
            setConcDB("jdbc:sqlite:2_SOLUCION/SOLUCION/bd/DB_Planes.db");
            Statement statement=concDB.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from Cliente");
            while (resultSet.next()){
                Cliente cliente= new Cliente(resultSet.getString("nombre"),resultSet.getString("cedula"),resultSet.getString("ciudad"),resultSet.getString("marca"),
                        resultSet.getString("modelo"),resultSet.getString("numeroCelular"),resultSet.getDouble("pagoMensual"),resultSet.getString("tipoPersonal"),
                        resultSet.getDouble("costoMatricula"));
                cliente.establecerDBNTotalPlanes(resultSet.getInt("numeroPlanes"));
                cliente.establecerDBTotal(resultSet.getDouble("Total"));
                clientes.add(cliente);
            }
            resultSet.close();
        }catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return clientes;
    }

    public Cliente actualizarCliente(String cedula) {
        Cliente clienteActualizado = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:2_SOLUCION/SOLUCION/bd/DB_Planes.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente WHERE cedula='" + cedula + "'");
            if (resultSet.next()) {
                clienteActualizado = new Cliente(resultSet.getString("nombre"),
                        resultSet.getString("cedula"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("numeroCelular"),
                        resultSet.getDouble("pagoMensual"),
                        resultSet.getString("tipoPersonal"),
                        resultSet.getDouble("costoMatricula"));
                clienteActualizado.establecerDBNTotalPlanes(resultSet.getInt("numeroPlanes"));
                clienteActualizado.establecerDBTotal(resultSet.getDouble("Total"));
                connection.close();
                statement.close();
                resultSet.close();
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return clienteActualizado;
    }
}
