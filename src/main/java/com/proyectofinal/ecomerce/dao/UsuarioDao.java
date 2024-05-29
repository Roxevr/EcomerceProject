package com.proyectofinal.ecomerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Usuario;


public interface UsuarioDao  extends JpaRepository<Usuario, Integer>{
	
}

