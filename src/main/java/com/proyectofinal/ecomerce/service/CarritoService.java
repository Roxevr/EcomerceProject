package com.proyectofinal.ecomerce.service;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.model.Usuario;

public interface CarritoService{

	Carrito obtenerCarritoPorUsuario(Usuario usuario);

	void guardarCarrito(Carrito carrito);

	// void deleteProductoCarrito(Producto producto);
	
}
