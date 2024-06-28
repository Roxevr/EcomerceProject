package com.proyectofinal.ecomerce.model.service;

import java.util.List;

import com.proyectofinal.ecomerce.model.Pedido;
import com.proyectofinal.ecomerce.model.User;

public interface PedidoService {
	
	List<Pedido> obtenerPedidosPorUsuario(User usuario);

	void guardarPedido(Pedido pedido);
}
