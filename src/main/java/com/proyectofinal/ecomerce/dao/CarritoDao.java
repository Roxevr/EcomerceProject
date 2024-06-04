package com.proyectofinal.ecomerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Producto;

public interface CarritoDao extends JpaRepository<Carrito, Long> {

	//@Query("")
	//void addItem(Producto producto);

	//void deleteItem(Producto producto);
}
