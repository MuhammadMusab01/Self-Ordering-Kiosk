package com.kiosk.self_ordering_kiosk.service;

import com.kiosk.self_ordering_kiosk.exception.GeneralException;
import com.kiosk.self_ordering_kiosk.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import com.kiosk.self_ordering_kiosk.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new GeneralException(202, "User not found: " + username));
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();
    }
}
