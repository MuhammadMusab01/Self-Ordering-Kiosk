package com.kiosk.self_ordering_kiosk.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralResponse {

    private String message;
    private int statusCode;
    private Object data;

    public GeneralResponse(int errorCode, String errorMessage) {
        this.statusCode = errorCode;
        this.message = errorMessage;
    }

    public GeneralResponse(int errorCode, String errorMessage, Object data) {
        this.statusCode = errorCode;
        this.message = errorMessage;
        this.data = data;
    }

    @Override
    public String toString(){
        return "GeneralResponse [statusCode=" + statusCode + ", message=" + message + "]";
    }

}
