package com.proyectofinal.ecomerce.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.model.Pedido;
import com.proyectofinal.ecomerce.model.User;
import com.proyectofinal.ecomerce.model.dao.PedidoDao;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	@Override
	public List<Pedido> obtenerPedidosPorUsuario(User usuario) {
		return pedidoDao.findAll();
	}

	@Override
	public void guardarPedido(Pedido pedido) {
		pedidoDao.save(pedido);
	}

}
