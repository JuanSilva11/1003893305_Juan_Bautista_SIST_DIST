/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.GrupoM;
import java.util.Objects;

/**
 *
 * @author ariel
 */
public class GrupoC {
    
    
    public void Crear(String tipoDocumento, String numeroDocumento, String nombreCompleto, String estado, String valor){
        
        GrupoM grupoM = new GrupoM();
        grupoM.setTipoDocumento(tipoDocumento);
        grupoM.setNumeroDocumento(numeroDocumento);
        grupoM.setNombreCompleto(nombreCompleto);
        grupoM.setEstado(Objects.equals(estado, "Activo") ? 1 : 0);
        grupoM.setValor(Integer.parseInt(valor));
        grupoM.Crear();
    }
    
    public void Eliminar(String id){
        GrupoM grupoM = new GrupoM();
        grupoM.setId(Integer.parseInt(id));
        grupoM.Eliminar();
    }
    
    public void Actualizar(String id, String tipoDocumento, String numeroDocumento, String nombreCompleto, String estado, String valor){
        GrupoM grupoM = new GrupoM();
        grupoM.setId(Integer.parseInt(id));
        grupoM.setTipoDocumento(tipoDocumento);
        grupoM.setNumeroDocumento(numeroDocumento);
        grupoM.setNombreCompleto(nombreCompleto);
        grupoM.setEstado(Objects.equals(estado, "Activo") ? 1 : 0);
        grupoM.setValor(Integer.parseInt(valor));
        grupoM.Actualizar();
    }
    
}
