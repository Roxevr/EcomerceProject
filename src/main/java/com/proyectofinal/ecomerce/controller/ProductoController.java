package com.proyectofinal.ecomerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> getProductos() {
		return productoService.findAll();
	}
	
	@GetMapping(value = "/productos/{id}")
	public Optional<Producto> getProducto(@PathVariable int id) {
		return productoService.findOne(id);
	}
	
	
	
}
