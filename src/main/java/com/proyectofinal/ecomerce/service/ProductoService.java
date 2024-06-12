package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoService {

	Producto save(Producto producto);

	Optional<Producto> findByCodigo(String codigo);

	List<Producto> findAll(String filter);

}
