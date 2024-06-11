package com.proyectofinal.ecomerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/agregar")
    public Carrito agregarProductoAlCarrito(@RequestParam String email, @RequestParam String codigoProducto) {
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
        Optional<Producto> producto = productoService.findByCodigo(codigoProducto);
        Carrito carrito = carritoService.obtenerCarritoPorUsuario(usuario);
        if (carrito == null) {
            carrito = new Carrito();
            carrito.setUsuario(usuario);
        }
        carrito.getProductos().add(producto.get());
        return carritoService.guardarCarrito(carrito);
    }
}
