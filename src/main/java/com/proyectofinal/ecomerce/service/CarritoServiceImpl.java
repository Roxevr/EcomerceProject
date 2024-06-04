package com.proyectofinal.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.CarritoDao;
import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.model.Usuario;

@Service
public class CarritoServiceImpl implements CarritoService {
	
	@Autowired
	private CarritoDao carritoDao;

	@Override
	public void getAllItems() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addItem(Producto producto) {
		//carritoDao.addItem(producto);

	}

	@Override
	public void deleteItem(Producto producto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllItems() {
		// TODO Auto-generated method stub

	}

	@Override
	public Carrito getCarrito(Usuario usuario) {
		if (usuario.getIdUsuario() == null) {
			return new Carrito();
		}
		return carritoDao.findById(usuario.getIdUsuario()).orElse(new Carrito());
	}

}
