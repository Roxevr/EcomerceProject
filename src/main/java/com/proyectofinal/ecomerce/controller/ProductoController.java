package com.proyectofinal.ecomerce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String obtenerTodosLosProductosView(Model model) {
    	model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        return "productos/productos";
    }
    
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }
    

    @GetMapping("/{codigo}")
    public String obtenerProductoPorCodigo(@PathVariable String codigo, Model model) {
    	model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        return "productos/producto";
    }
}
