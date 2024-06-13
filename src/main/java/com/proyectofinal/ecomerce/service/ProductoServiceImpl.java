package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.ProductoDao;
import com.proyectofinal.ecomerce.model.Producto;

import jakarta.transaction.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional
	public void save(Producto producto) {
        productoDao.save(producto);
    }

	@Override
    public Producto findByCodigo(String codigo) {
        return productoDao.findByCodigo(codigo).orElse(null);
    }
	
	@Override
	public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }
	
	@Override
	@Transactional
	public void update(Producto producto, int eliminarStock) {
		productoDao.findById(producto.getIdProducto()).stream().findFirst().ifPresent(p ->{
			p.setCantidad(p.getCantidad() - eliminarStock);
		});
	}

	@Override
    public List<Producto> findAll(String filter) {
		if(filter == null || filter.isBlank()  ) {
			return productoDao.findAll();
		}
        return productoDao.findAll().stream().filter(p -> p.getNombre().toUpperCase().contains(filter.toUpperCase())).toList();
    }

}
