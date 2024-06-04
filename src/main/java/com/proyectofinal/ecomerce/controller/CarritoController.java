package com.proyectofinal.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.ecomerce.model.Usuario;
import com.proyectofinal.ecomerce.service.CarritoService;

@Controller
public class CarritoController {
	
	@Autowired
	private CarritoService carritoService;
	
	@GetMapping(value = "/carrito")
	public String carrito(Model model, Usuario usuario) {
		model.addAttribute("carrito", carritoService.getCarrito(usuario));
		return "carritos/carrito";
	}
}
