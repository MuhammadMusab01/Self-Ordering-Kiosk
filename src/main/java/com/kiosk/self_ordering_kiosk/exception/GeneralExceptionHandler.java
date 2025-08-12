package com.kiosk.self_ordering_kiosk.exception;

import com.kiosk.self_ordering_kiosk.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionHandler {

    @Autowired
    HttpServletRequest request;

    private final MessageService messageService;
    private static final String PARAMETER_REQ_CHECK = "parameter.req.check";

    @ExceptionHandler(GeneralException.class)
    @ResponseBody
    protected GeneralResponse handleGeneralGeneratedException(GeneralException ex) {
        try {
            String userRequest = Objects.nonNull(request.getAttribute(VariableConstant.REQUEST)) ? request.getAttribute(VariableConstant.REQUEST).toString() : "";
            log.error("common exception is " + ex.getMessage() + " for request: " + userRequest, ex);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error(ex.getMessage(), ex);
        }

        return new GeneralResponse(ex.getStatusCode(),ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected GeneralResponse handleGeneralException(Exception ex){
        try {
            String userRequest = Objects.nonNull(request.getAttribute(VariableConstant.REQUEST)) ? request.getAttribute(VariableConstant.REQUEST).toString() : "";
            log.error("common exception is " + ex.getMessage() + " for request: " + userRequest, ex);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error(ex.getMessage(), ex);
        }

        return new GeneralResponse(messageService.getCCode(VariableConstant.UNKNOWN_ERROR),messageService.getMessage(VariableConstant.UNKNOWN_ERROR));
    }
}
