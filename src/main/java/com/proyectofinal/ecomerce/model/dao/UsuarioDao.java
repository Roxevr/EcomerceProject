package com.proyectofinal.ecomerce.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.User;


public interface UsuarioDao  extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}

