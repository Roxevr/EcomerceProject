package com.proyectofinal.ecomerce.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoRepository {
		
	public Producto findOne(int idProducto);
	
	public List<Producto> findAll();
	
	public void save(Producto p);
	
	public void update(Producto p);
	
	public void delete(Producto p);
}
