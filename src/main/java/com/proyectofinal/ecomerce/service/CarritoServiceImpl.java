package com.proyectofinal.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.CarritoDao;
import com.proyectofinal.ecomerce.dao.ProductoDao;
import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Producto;
import com.proyectofinal.ecomerce.model.Usuario;

import jakarta.transaction.Transactional;

@Service
public class CarritoServiceImpl implements CarritoService {
	
	@Autowired
	private CarritoDao carritoDao;
	
	@Autowired
	private ProductoService productoService;

	@Override
    public Carrito obtenerCarritoPorUsuario(Usuario usuario) {
        return carritoDao.findByUsuario(usuario).orElse(null);
    }
	
	@Override
	@Transactional
    public void guardarCarrito(Carrito carrito) {
		if(carrito.getUsuario() != null) {
			for (Producto producto : carrito.getProductos()) {
				productoService.update(producto, 1);
			}
			carritoDao.save(carrito);
		}
        
    }

}
