package com.corhuila.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "proyecto_usuario",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"proyecto_id", "usuario_id"}
        )
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proyecto_id", nullable = false)
    @JsonIgnore
    private Long projectId;

    @Column(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", insertable = false, updatable = false)
    private ProjectEntity project;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private UserEntity user;

}
