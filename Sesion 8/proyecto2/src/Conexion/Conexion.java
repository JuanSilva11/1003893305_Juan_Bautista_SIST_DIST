/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;
    private String url ;
    private String usuario;
    private String contrasenia;

    // Constructor que recibe los datos de conexión
    public Conexion() {
        this.url = "jdbc:mysql://localhost:3306/ejemplo1";
        this.usuario = "root";
        this.contrasenia = "admin";
    }

    // Método para establecer la conexión
    public void conectar() {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasenia);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para ejecutar manipulaciones de datos (insert, update, delete)
    public int ejecutarUpdate(String sql) {
        try {
            // Crear un objeto PreparedStatement
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la manipulación de datos
            int filasAfectadas = statement.executeUpdate();

            // Cerrar el statement
            statement.close();

            return filasAfectadas;

        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la manipulación de datos: " + e.getMessage());
            e.printStackTrace();
            return -1; // Retorna -1 en caso de error
        }
    }

    // Método para realizar consultas y obtener datos
    public ResultSet ejecutarQuery(String sql) {
        try {
            // Crear un objeto PreparedStatement
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el ResultSet
            ResultSet resultSet = statement.executeQuery();

            return resultSet;

        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la consulta: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
