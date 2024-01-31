package com.corhuila.proyecto.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Constants {

    RESPONSE_CODE_01(1, "CONSUMO EXITOSO"),

    RESPONSE_CODE_02(2, "NO SE ENCONTRÓ EL REGISTRO SOLICITADO"),

    RESPONSE_CODE_03(3, "HA VIOLADO UNA RESTRICCIÓN DE INTEGRIDAD EN LA BASE DE DATOS"),

    RESPONSE_CODE_04(4, "EL REGISTRO ESPECIFICADO A ACTUALIZAR NO EXISTE"),

    RESPONSE_CODE_05(5, "EL REGISTRO A ELIMINAR NO EXISTE"),

    RESPONSE_CODE_06(6, "LOS DATOS DE ENTRADA INGRESADOS NO SON VÁLIDOS"),

    RESPONSE_CODE_07(7, "HA OCURRIDO UN ERROR INESPERADO");

    private final Integer code;

    private final String message;

}
