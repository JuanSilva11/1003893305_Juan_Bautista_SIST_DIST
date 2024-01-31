package com.corhuila.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Response<T> {

    @JsonProperty("codigoRespuesta")
    private Integer responseCode;

    @JsonProperty("mensajeRespuesta")
    private String responseMessage;

    @JsonProperty("data")
    private T data;

}
