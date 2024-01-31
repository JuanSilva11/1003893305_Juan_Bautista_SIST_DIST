package com.corhuila.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "seguimiento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowUpEntity extends Audit {

    @Column(name = "fecha_inicio", nullable = false)
    @JsonProperty("fechaInicio")
    private LocalDateTime startDate;

    @Column(name = "fecha_fin", nullable = false)
    @JsonProperty("fechaFin")
    private LocalDateTime endDate;

    @Column(name = "observaciones", nullable = false)
    @JsonProperty("observaciones")
    private String observations;

    @Column(name = "tarea_id", nullable = false)
    @JsonProperty("tareaId")
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "tarea_id", insertable = false, updatable = false)
    @JsonProperty("tarea")
    private TaskEntity task;

}
