package com.sisdis.seguridad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "rol_id", nullable = false)
    private Long rolId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true, insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rol_id", nullable = false, unique = true, insertable = false, updatable = false)
    private Rol rol;

}
