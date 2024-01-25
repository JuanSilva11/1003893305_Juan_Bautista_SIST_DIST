package com.sisdis.seguridad.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisdis.seguridad.Entity.Persona;
import com.sisdis.seguridad.IRepository.IPersonaRepository;
import com.sisdis.seguridad.IService.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaRepository repository;
	
	@Override
	public List<Persona> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Persona> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Persona save(Persona persona) {
		
		persona.setFechaCreacion(LocalDateTime.now());		
		return repository.save(persona);
	}

	@Override
	public void update(Persona persona, Long id) {
		//validar si existe.            
        Optional<Persona> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Persona personaUpdate = op.get();
            personaUpdate.setTipoDocumento(persona.getTipoDocumento());
            personaUpdate.setDocumento(persona.getDocumento());
            personaUpdate.setNombre(persona.getNombre());
            personaUpdate.setApellido(persona.getApellido());
            personaUpdate.setCorreo(persona.getCorreo());
            personaUpdate.setDireccion(persona.getDireccion());
            personaUpdate.setEstado(persona.getEstado());
            personaUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(personaUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<Persona> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Persona personaUpdate = op.get();
            personaUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(personaUpdate);
        }		
	}	
}
