package com.corhuila.proyecto.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectEntity extends Audit {

    @Column(name = "nombre", nullable = false)
    @JsonProperty("nombre")
    private String name;

    @Column(name = "descripcion", nullable = false)
    @JsonProperty("descripcion")
    private String description;

    @Column(name = "fecha_inicio", nullable = false)
    @JsonProperty("fechaInicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;

    @Column(name = "fecha_fin", nullable = false)
    @JsonProperty("fechaFin")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date endDate;

}
