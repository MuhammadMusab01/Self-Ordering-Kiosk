package com.kiosk.self_ordering_kiosk;

import com.kiosk.self_ordering_kiosk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);  // ✅ must match entity field
}
