package com.proyectofinal.ecomerce.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Product;

public interface ProductoDao  extends JpaRepository<Product, Long>{
	Optional<Product> findByCodigo(String codigo);
}
