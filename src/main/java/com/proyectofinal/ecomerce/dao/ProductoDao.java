package com.proyectofinal.ecomerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoDao  extends JpaRepository<Producto, Integer>{
		
}
