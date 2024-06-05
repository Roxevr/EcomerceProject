package com.proyectofinal.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Pedido;
import com.proyectofinal.ecomerce.model.Usuario;
import com.proyectofinal.ecomerce.service.CarritoService;
import com.proyectofinal.ecomerce.service.PedidoService;
import com.proyectofinal.ecomerce.service.UsuarioService;

@RestController
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private CarritoService carritoService;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/crear")
	public Pedido crearPedido(@RequestParam String email) {
		Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
		Carrito carrito = carritoService.obtenerCarritoPorUsuario(usuario);
		Pedido pedido = new Pedido();
		pedido.setUsuario(usuario);
		pedido.setProductos(carrito.getProductos());
		carrito.getProductos().clear(); // Vaciar el carrito
		carritoService.guardarCarrito(carrito);
		return pedidoService.guardarPedido(pedido);
	}
}
