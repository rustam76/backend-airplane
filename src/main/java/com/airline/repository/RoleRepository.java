package com.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airline.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

   Optional<Role> findByName(String name);
}
