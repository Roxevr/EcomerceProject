package com.proyectofinal.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.PedidoDao;
import com.proyectofinal.ecomerce.model.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	@Override
	public Pedido guardarPedido(Pedido pedido) {
		return pedidoDao.save(pedido);
	}

}
