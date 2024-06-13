package com.proyectofinal.ecomerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Usuario;


public interface UsuarioDao  extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);
}

