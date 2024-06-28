package com.proyectofinal.ecomerce.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.Product;
import com.proyectofinal.ecomerce.model.User;
import com.proyectofinal.ecomerce.model.dao.CarritoDao;
import com.proyectofinal.ecomerce.model.dao.ProductoDao;

import jakarta.transaction.Transactional;

@Service
public class CarritoServiceImpl implements CarritoService {
	
	@Autowired
	private CarritoDao carritoDao;
	
	@Autowired
	private ProductoService productoService;

	@Override
    public Carrito obtenerCarritoPorUsuario(User usuario) {
        return carritoDao.findByUsuario(usuario).orElse(null);
    }

	@Override
	public void guardarCarrito(Carrito carrito) {
		carritoDao.save(carrito);
	}
	
	/*
	@Override
	public void deleteProductoCarrito(Producto producto) {
		carritoDao.deleteProducto(producto);
	}
	*/
	
	/* 
	@Override
	@Transactional
    public void guardarCarrito(Carrito carrito) {
		if(carrito.getUsuario() != null) {
			for (Producto producto : carrito.getProductos()) {
				productoService.update(producto, 1);
			};
			if(carritoDao.findById(carrito.getIdCarrito()).isPresent()) {
				carritoDao.findById(carrito.getIdCarrito()).stream().findFirst().orElse(null).setProductos(carrito.getProductos());
			}else {
				carritoDao.save(carrito);
			}
		}
		
    }
    */

}
