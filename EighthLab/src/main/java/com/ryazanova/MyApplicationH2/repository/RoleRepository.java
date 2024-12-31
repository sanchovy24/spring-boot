package com.ryazanova.MyApplicationH2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ryazanova.MyApplicationH2.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
