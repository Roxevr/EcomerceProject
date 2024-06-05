package com.proyectofinal.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.CarritoDao;
import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Usuario;

@Service
public class CarritoServiceImpl implements CarritoService {
	
	@Autowired
	private CarritoDao carritoDao;

	@Override
    public Carrito obtenerCarritoPorUsuario(Usuario usuario) {
        return carritoDao.findByUsuario(usuario);
    }
	
	@Override
    public Carrito guardarCarrito(Carrito carrito) {
        return carritoDao.save(carrito);
    }

}
