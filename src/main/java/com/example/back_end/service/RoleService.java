package com.example.back_end.service;

import com.example.back_end.repository.RoleRepository;

import com.example.back_end.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role){
    return roleRepository.save(role);
    }
}
