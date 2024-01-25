package com.sisdis.seguridad.IService;

import java.util.List;
import java.util.Optional;

import com.sisdis.seguridad.Entity.Usuario;

public interface IUsuarioService {

	//Obtener todo
	public List<Usuario> all();
	
	//Obtener por ID
	public Optional<Usuario> findById(Long id);
 	
	//Crear
	public Usuario save(Usuario usuario);
	
	//Modificar
	public void update(Usuario usuario, Long id);
	
	//Eliminar Físico
	public void deletePhysical(Long id);
		
	// Eliminar lógico
	public void deleteLogical(Long id);
}
