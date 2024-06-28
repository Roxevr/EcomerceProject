package com.proyectofinal.ecomerce.model.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinal.ecomerce.model.Product;

public interface ProductoService {
	
	List<Product> findAll(String filter);

	Product findById(Long id);
	
	Product findByCodigo(String codigo);

	void save(Product producto);
	
	void update(Product producto, int eliminarStock);

	

	

	

}
