package com.proyectofinal.ecomerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Usuario;

public interface CarritoDao extends JpaRepository<Carrito, Long> {
	Carrito findByUsuario(Usuario usuario);

}
