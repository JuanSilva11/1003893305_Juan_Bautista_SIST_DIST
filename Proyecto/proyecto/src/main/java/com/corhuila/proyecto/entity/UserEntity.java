package com.corhuila.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity extends Audit {

    @Column(name = "tipo_documento", nullable = false)
    @JsonProperty("tipoDocumento")
    private String documentType;

    @Column(name = "numero_documento", nullable = false, unique = true)
    @JsonProperty("numeroDocumento")
    private String documentNumber;

    @Column(name = "nombres", nullable = false)
    @JsonProperty("nombres")
    private String names;

    @Column(name = "apellidos", nullable = false)
    @JsonProperty("apellidos")
    private String surnames;

}
