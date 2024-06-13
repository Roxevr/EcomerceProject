package com.proyectofinal.ecomerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.model.Usuario;
import com.proyectofinal.ecomerce.service.CarritoService;
import com.proyectofinal.ecomerce.service.ProductoService;
import com.proyectofinal.ecomerce.service.UsuarioService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired
    private CarritoService carritoService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("")
    public String getCarrito(Model model, @RequestParam(name = "email", required = false) String email) {
    	//Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
    	Usuario usuario = usuarioService.obtenerUsuarioPorId(1L);
    	Carrito carrito = carritoService.obtenerCarritoPorUsuario(usuario);
    	
    	if(usuario != null) {
        	carrito = (carrito == null) ? new Carrito(usuario) : carrito;
        }else {
        	carrito = new Carrito();
        }
    	
    	model.addAttribute("carrito", carrito);
    	return "/carritos/carrito";
    }

    @PostMapping("/agregar")
    public String agregarProductoAlCarrito(@RequestParam(name = "email", required = false) String email,
    		@RequestParam(name = "codigoProducto", required = true) String codigoProducto) {
    	
        //Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
        Usuario usuario = usuarioService.obtenerUsuarioPorId(1L);
        Producto producto = productoService.findByCodigo(codigoProducto);
        Carrito carrito = carritoService.obtenerCarritoPorUsuario(usuario);
        
        if(usuario != null) {
        	carrito = (carrito == null) ? new Carrito(usuario) : carrito;
        }else {
        	carrito = new Carrito();
        }

        carrito.agregarProducto(producto);
        carritoService.guardarCarrito(carrito);
        
        return "redirect:/carrito";
    }
}
