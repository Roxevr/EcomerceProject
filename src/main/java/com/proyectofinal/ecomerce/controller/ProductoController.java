package com.proyectofinal.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectofinal.ecomerce.dao.ProductoDaoImpl;

@Controller
@RequestMapping(value = "")
public class ProductoController {

	@Autowired
	private ProductoDaoImpl productoRepositoryImpl;

	@GetMapping(value = "/productos")
	public String show() {
		return "init";
	}
}
