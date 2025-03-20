package com.repasandoJPASring.demo.model;

import lombok.Data;

@Data
public class ApiResponse {

    private String statusDeLMsg;
    private Object cuerpoDeLaRespuesta;
    private String error;

    public ApiResponse() {
    }

    public ApiResponse(String msg, Object data, String error) {
        this.statusDeLMsg = msg;
        this.cuerpoDeLaRespuesta = data;
        this.error = error;
    }

}

