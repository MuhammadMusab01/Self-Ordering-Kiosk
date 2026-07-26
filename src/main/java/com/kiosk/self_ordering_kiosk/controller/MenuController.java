package com.kiosk.self_ordering_kiosk.controller;

import com.kiosk.self_ordering_kiosk.exception.GeneralException;
import com.kiosk.self_ordering_kiosk.exception.GeneralResponse;
import com.kiosk.self_ordering_kiosk.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
public class MenuController {
private final UserRepository userRepository;


    @PostMapping("/hello")
    public GeneralResponse hello(Principal principal) {
       throw new GeneralException(202,"Error");

    }
}
