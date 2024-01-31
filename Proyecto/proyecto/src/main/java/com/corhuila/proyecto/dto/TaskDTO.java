package com.corhuila.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("historia")
    private String history;

    @JsonProperty("descripcion")
    private String description;

    @JsonProperty("criteriosAceptacion")
    private String acceptanceCriteria;

    @JsonProperty("proyectoId")
    private Long projectId;

}
