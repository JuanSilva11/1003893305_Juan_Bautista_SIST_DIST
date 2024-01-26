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
    
    Integer id;
    String tipoDocumento;
    String numeroDocumento;
    String nombreCompleto;
    Integer estado;
    Integer valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public void Crear() {
        conn.conectar();
        String sql = "INSERT INTO credito (tipo_documento, documento, nombre_completo, estado_credito, valor_credito) "
                + "VALUES ('" + this.getTipoDocumento() + "', '" + this.getNumeroDocumento() + "', '" + this.nombreCompleto + "', " + this.getEstado() + ", " + this.getValor() + ")";
        conn.ejecutarUpdate(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Actualizar() {
        conn.conectar();
        String sql = "UPDATE credito SET tipo_documento = '" + this.getTipoDocumento() + "', documento = '" + this.getNumeroDocumento() + "', nombre_completo = '" + this.getNombreCompleto() + "', estado_credito = " + this.getEstado() + ", valor_credito = " + this.getValor() + " WHERE id = " + this.getId() + ";";
        conn.ejecutarUpdate(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
        conn.conectar();
        String sql = "DELETE FROM credito WHERE id = " + this.id + ";";
        conn.ejecutarUpdate(sql);
        conn.cerrarConexion();
    }
    
}
