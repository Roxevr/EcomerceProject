package com.proyectofinal.ecomerce.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.service.ProductoService;

@Controller
@RequestMapping({"/productos", "/"})
@CrossOrigin
public class ProductoController {

	@Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String obtenerTodosLosProductosView(Model model) {
    	model.addAttribute("productos", productoService.findAll());
        return "productos/productos";
    }
    
    @GetMapping("/{codigo}")
    public String getProductoPorCodigo(@PathVariable String codigo, Model model) {
    	Optional<Producto> prod = productoService.findByCodigo(codigo);
    	System.out.println(prod.toString());
    	model.addAttribute("producto", prod.get());
        return "productos/producto";
    }
    
    @PostMapping
    public Producto save(@RequestBody Producto producto) {
        return productoService.save(producto);
    }
    

    
}
