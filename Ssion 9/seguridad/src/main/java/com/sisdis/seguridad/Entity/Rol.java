package com.sisdis.seguridad.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 20, nullable = false)
	private String codigo;
	
	@Column(name = "nombre", length = 11, nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "descripcion", length = 50, nullable = false)
	private String descripcion;
	
	@Column(name = "estado", nullable = true)
	private Boolean estado;
	
	@Column(name = "fecha_creacion", nullable = true)
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private LocalDateTime fechaModificacion;
	
	@Column(name = "fecha_eliminacion", nullable = true)
	private LocalDateTime fechaEliminacion;	
}


