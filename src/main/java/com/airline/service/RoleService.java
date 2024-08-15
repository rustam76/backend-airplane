package com.airline.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.airline.model.Role;
import com.airline.repository.RoleRepository;

public class RoleService {
    @Autowired
    public RoleRepository roleRepository;
        public Role  findRoleById(Long id) {
            return roleRepository.findById(id).orElse(null);// roleRepository.findById(id);
        }
}
