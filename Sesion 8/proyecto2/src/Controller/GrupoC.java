/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.GrupoM;

/**
 *
 * @author ariel
 */
public class GrupoC {
    public void Agregar(int numeroGrupo){
        //Objeto del modelo
        GrupoM grupoM = new GrupoM();
        grupoM.setNumeroGrupo(numeroGrupo);
        grupoM.Agregar();
    }
    
    public void Modificar(int id, int numeroGrupo){
        GrupoM grupoM = new GrupoM();
        grupoM.setId(id);
        grupoM.setNumeroGrupo(numeroGrupo);
        grupoM.Modificar();
    }
    
    public void Eliminar(int id){
        GrupoM grupoM = new GrupoM();
        grupoM.setId(id);
        grupoM.Eliminar();
    }
}
