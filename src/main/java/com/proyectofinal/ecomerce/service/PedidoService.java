package com.proyectofinal.ecomerce.service;

import java.util.List;

import com.proyectofinal.ecomerce.model.Pedido;
import com.proyectofinal.ecomerce.model.Usuario;

public interface PedidoService {
	
	List<Pedido> obtenerPedidosPorUsuario(Usuario usuario);

	void guardarPedido(Pedido pedido);
}
