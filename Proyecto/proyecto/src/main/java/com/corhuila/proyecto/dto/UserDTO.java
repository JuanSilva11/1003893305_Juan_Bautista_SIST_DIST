package com.corhuila.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("tipoDocumento")
    private String documentType;

    @JsonProperty("numeroDocumento")
    private String documentNumber;

    @JsonProperty("nombres")
    private String names;

    @JsonProperty("apellidos")
    private String surnames;

}
