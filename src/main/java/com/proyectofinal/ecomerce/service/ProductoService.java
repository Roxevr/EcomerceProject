package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoService {
	List<Producto> findAll();
	
	Producto findOne(int id);

}
