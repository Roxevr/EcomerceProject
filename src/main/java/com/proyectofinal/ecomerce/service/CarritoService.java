package com.proyectofinal.ecomerce.service;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.model.Usuario;

public interface CarritoService{
	
	Carrito getCarrito(Usuario usuario);
	
	void getAllItems();
	
	void addItem(Producto producto);
	
	void deleteItem(Producto producto);
	
	void deleteAllItems();
}
