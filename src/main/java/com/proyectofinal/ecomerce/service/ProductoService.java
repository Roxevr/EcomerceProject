package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoService {

	public Producto save(Producto producto);

	public Optional<Producto> findByCodigo(String codigo);

	public List<Producto> findAll();

}
