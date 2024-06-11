package com.proyectofinal.ecomerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoDao  extends JpaRepository<Producto, Long>{
	Optional<Producto> findByCodigo(String codigo);
}
