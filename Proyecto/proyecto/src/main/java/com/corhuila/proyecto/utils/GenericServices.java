package com.corhuila.proyecto.utils;

import com.corhuila.proyecto.dto.Response;

public class GenericServices {

    public static <T> Response<T> buildResponse(Integer responseCode, String responseMessage, T data) {
        return Response.<T>builder()
                .responseCode(responseCode)
                .responseMessage(responseMessage)
                .data(data)
                .build();
    }

}
