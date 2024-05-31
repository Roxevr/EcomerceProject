package com.proyectofinal.ecomerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.proyectofinal.ecomerce.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping(value = "/productos")
	public String showProductos(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos/init";
	}
	
	@GetMapping(value = "/productos/{id}")
	public String showProducto(Model model, @PathVariable int id) {
		model.addAttribute("producto",  productoService.findOne(id));
		return "productos/one";
	}
	
	
	
}
