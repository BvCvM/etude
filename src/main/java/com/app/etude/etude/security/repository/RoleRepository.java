package com.app.etude.etude.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.etude.etude.security.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String roleStudent);
}
