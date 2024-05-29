package com.proyectofinal.ecomerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Carrito;

public interface CarritoDao  extends JpaRepository<Carrito, Integer>{
	
}

