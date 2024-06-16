package com.proyectofinal.ecomerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.PedidoDao;
import com.proyectofinal.ecomerce.model.Pedido;
import com.proyectofinal.ecomerce.model.Usuario;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	@Override
	public List<Pedido> obtenerPedidosPorUsuario(Usuario usuario) {
		return pedidoDao.findAll();
	}

	@Override
	public void guardarPedido(Pedido pedido) {
		pedidoDao.save(pedido);
	}

}
