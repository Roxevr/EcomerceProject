package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoService {
	List<Producto> finAll();
	
	Optional<Producto> finOne(int id);
}
