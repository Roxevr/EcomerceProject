package com.proyectofinal.ecomerce.service;

import com.proyectofinal.ecomerce.model.Producto;

public interface CarritoService{
	
	void getAllItems();
	
	void addItem(Producto producto);
	
	void deleteItem(Producto producto);
	
	void deleteAllItems();
}
