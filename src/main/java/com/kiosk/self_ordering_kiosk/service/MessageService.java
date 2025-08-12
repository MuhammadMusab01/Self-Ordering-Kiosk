package com.kiosk.self_ordering_kiosk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageService {
    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code + ".message", null, locale);
    }

    public Integer getCCode(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return Integer.parseInt(messageSource.getMessage(code + ".code", null, locale).trim());
    }
}
