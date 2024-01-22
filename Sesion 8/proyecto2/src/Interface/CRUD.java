/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

/**
 *
 * @author ariel
 */
public interface CRUD {
    
    //Método para agregar
    public void Agregar();
    
    //Método para modificar
    public void Modificar();
    
    //Método para eliminar
    public void Eliminar();
    
    //Método para agregar
    public Object Consultar();
    
    //Método para Consultar por id
    public Object ConsultarId();
}
