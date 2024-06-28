package com.proyectofinal.ecomerce.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Role;

public interface RoleDao extends JpaRepository<Role, Long>{
	Optional<Role> findByName(String name);
}
