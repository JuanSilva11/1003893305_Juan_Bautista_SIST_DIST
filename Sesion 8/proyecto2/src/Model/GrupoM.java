/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Conexion.Conexion;
import Interface.CRUD;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author ariel
 */
public class GrupoM implements CRUD{
    
    Conexion conn = new Conexion();
    
    private int id;
    private int numeroGrupo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    
  
    
    @Override
    public void Agregar() {
        // Establecer la conexión
        conn.conectar();
        
         // Puedes realizar operaciones en la base de datos aquí, por ejemplo:
        String sql = "INSERT INTO grupo (numero_grupo) VALUES ("+this.getNumeroGrupo()+")";
        
        conn.ejecutarUpdate(sql);
        
        // Cerrar la conexión
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        conn.conectar();
        
        String sql = "UPDATE grupo SET numero_grupo = " + this.getNumeroGrupo() + " WHERE id = " + this.getId();
        System.out.println("SQL a ejecutar: " + sql);
        conn.ejecutarUpdate(sql);
        
        conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
        conn.conectar();
        
        String sql = "DELETE FROM grupo WHERE id = " + this.getId();
        
        conn.ejecutarUpdate(sql);
        
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
         // Realizar una consulta y obtener datos
        //ResultSet resultSet = conexion.ejecutarQuery("SELECT * FROM grupo");
    }

    @Override
    public Object ConsultarId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
