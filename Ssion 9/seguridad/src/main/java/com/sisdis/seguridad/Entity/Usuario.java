package com.sisdis.seguridad.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "usuario", length = 20, nullable = false)
	private String usuario;
	
	@Column(name = "contrasenia", length = 11, nullable = false, unique = true)
	private String contrasenia;
	
	@Column(name = "estado", nullable = true)
	private Boolean estado;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private LocalDateTime fechaModificacion;
	
	@Column(name = "fecha_eliminacion", nullable = true)
	private LocalDateTime fechaEliminacion;	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "persona_id", nullable = false, unique = true)	
	private Persona personaId;
}


