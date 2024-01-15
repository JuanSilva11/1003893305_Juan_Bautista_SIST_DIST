package org.solid.dip;

public class Aplicacion {

    private ConexionBaseDatos conexion;

    public Aplicacion(ConexionBaseDatos conexion) {
        this.conexion = conexion;
    }

    public void ejecutar() {
        conexion.conectar();
        // ...
        conexion.desconectar();
    }

    public static void main(String[] args) {
        Aplicacion app = new Aplicacion(new ConexionMySQL());
        app.ejecutar();
    }

}
