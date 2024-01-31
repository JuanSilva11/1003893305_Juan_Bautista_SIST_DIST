package com.corhuila.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tarea")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskEntity extends Audit {

    @Column(name = "historia", nullable = false)
    @JsonProperty("historia")
    private String history;

    @Column(name = "descripcion", nullable = false)
    @JsonProperty("descripcion")
    private String description;

    @Column(name = "criterios_acpetacion", nullable = false)
    @JsonProperty("criteriosAceptacion")
    private String acceptanceCriteria;

    @Column(name = "proyecto_id", nullable = false)
    @JsonProperty("proyectoId")
    private Long projectId;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", insertable = false, updatable = false)
    @JsonProperty("proyecto")
    private ProjectEntity project;

}
