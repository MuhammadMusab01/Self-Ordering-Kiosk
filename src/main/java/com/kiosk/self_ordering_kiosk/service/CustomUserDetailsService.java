package com.kiosk.self_ordering_kiosk.service;

import com.kiosk.self_ordering_kiosk.UserRepository;
import com.kiosk.self_ordering_kiosk.exception.GeneralException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
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
 //       com.kiosk.self_ordering_kiosk.entity.User user = userRepository.findByUserName(username)
 //               .orElseThrow(() -> new GeneralException(202, "User not found: " + username));
        return User.withUsername("admin")
                .password(passwordEncoder.encode("1234"))
                .build();
    }
}
