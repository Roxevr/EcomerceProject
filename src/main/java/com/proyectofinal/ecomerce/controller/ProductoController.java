package com.proyectofinal.ecomerce.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.service.ProductoService;

@Controller
@RequestMapping({"/productos", "/"})
@CrossOrigin
public class ProductoController {

	@Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String getTodosLosProductosView(Model model, @RequestParam(name = "filter", required = false) String filtro) {
    	model.addAttribute("productos", productoService.findAll(filtro));
        return "productos/productos";
    }
    
    @GetMapping("producto")
    public String getProductoPorCodigoView(Model model, @RequestParam(name = "cod", required = true) String codigo) {
    	Producto prod = productoService.findByCodigo(codigo);
    	System.out.println(prod.toString());
    	model.addAttribute("producto", prod);
        return "productos/producto";
    }
    
    @PostMapping
    public String save(@RequestBody Producto producto) {
    	productoService.save(producto);
    	return "";
    }
    

    
}
