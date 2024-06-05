package com.proyectofinal.ecomerce.service;

import java.util.List;

import com.proyectofinal.ecomerce.model.Producto;

public interface ProductoService {

	Producto guardarProducto(Producto producto);

	Producto obtenerProductoPorCodigo(String codigo);

	List<Producto> obtenerTodosLosProductos();

}
