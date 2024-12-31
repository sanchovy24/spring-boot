package com.ryazanova.MyApplicationH2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ryazanova.MyApplicationH2.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
