package com.proyectofinal.ecomerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.model.Usuario;
import com.proyectofinal.ecomerce.service.CarritoService;
import com.proyectofinal.ecomerce.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CarritoService carritoService;

	@GetMapping(value = "/productos")
	public String showProductos(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos/productos";
	}
	
	@GetMapping(value = "/productos/{id}")
	public String showProducto(Model model, @PathVariable int id) {
		model.addAttribute("producto",  productoService.findOne(id));
		return "productos/producto";
	}
	
	@PostMapping(value = "/productos/{id}/añadirCarrito")
	public String addCarrito(Model model, @PathVariable int id, Usuario usuario) {
		Producto producto = productoService.findOne(id);
		
		model.addAttribute("producto",  producto);
		carritoService.addItem(producto);

		return "productos/one";
	}
	
	
}
