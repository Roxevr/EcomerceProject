package com.proyectofinal.ecomerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.ProductoDao;
import com.proyectofinal.ecomerce.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public Producto guardarProducto(Producto producto) {
        return productoDao.save(producto);
    }

	@Override
    public Producto obtenerProductoPorCodigo(String codigo) {
        return productoDao.findByCodigo(codigo);
    }

	@Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoDao.findAll();
    }

}
