package com.proyectofinal.ecomerce.model.service;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Product;
import com.proyectofinal.ecomerce.model.User;

public interface CarritoService{

	Carrito obtenerCarritoPorUsuario(User usuario);

	void guardarCarrito(Carrito carrito);

	// void deleteProductoCarrito(Producto producto);
	
}
