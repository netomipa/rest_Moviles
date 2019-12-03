package mx.tec.rest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() throws SQLException {
        String cadenaConexion = "jdbc:mysql://localhost/estacionaTECDB?user=root&password=" +
                "&serverTimezone=America/Mexico_City&useSSL=false&allowPublicKeyRetrieval=true";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(cadenaConexion);
    }

    public static void main(String[] args) {
        try {
            if(Conexion.getConexion() != null)
                System.out.println("Conexión realizada");
            else
                System.out.println("Fallo de conexión");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}