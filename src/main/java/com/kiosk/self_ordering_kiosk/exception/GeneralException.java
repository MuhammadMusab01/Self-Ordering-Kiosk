package com.kiosk.self_ordering_kiosk.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;

@Getter
@Setter
@Slf4j
public class GeneralException extends RuntimeException {
    private int statusCode;
    private String message;

    private HttpServletResponse response;
    private ObjectMapper mapper = new ObjectMapper();

    public GeneralException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public GeneralException() {
        super();
    }

    @Override
    public String toString() {
        return "GeneralException [statusCode=" + statusCode + ", message=" + message + "]";
    }
}
