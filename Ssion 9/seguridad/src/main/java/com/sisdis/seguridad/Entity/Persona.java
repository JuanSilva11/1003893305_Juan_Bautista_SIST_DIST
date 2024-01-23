package com.sisdis.seguridad.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo_documento", length = 20, nullable = false)
	private String tipoDocumento;
	
	@Column(name = "documento", length = 11, nullable = false, unique = true)
	private String documento;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 50, nullable = false)
	private String apellido;
	
	@Column(name = "correo", length = 50, nullable = false, unique = true)
	private String correo;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
	@Column(name = "estado", nullable = true)
	private Boolean estado;
	
	@Column(name = "fecha_creacion", nullable = true)
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private LocalDateTime fechaModificacion;
	
	@Column(name = "fecha_eliminacion", nullable = true)
	private LocalDateTime fechaEliminacion;	
}
