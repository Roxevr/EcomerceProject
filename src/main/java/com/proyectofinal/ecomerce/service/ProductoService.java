package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoService {
	
	List<Producto> findAll(String filter);

	Producto findById(Long id);
	
	Producto findByCodigo(String codigo);

	void save(Producto producto);
	
	void update(Producto producto, int eliminarStock);

	

	

	

}
