package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.ProductoDao;
import com.proyectofinal.ecomerce.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

	@Override
    public Optional<Producto> findByCodigo(String codigo) {
        return productoDao.findByCodigo(codigo);
    }

	@Override
    public List<Producto> findAll(String filter) {
		if(filter == null || filter.isBlank()  ) {
			return productoDao.findAll();
		}
        return productoDao.findAll().stream().filter(p -> p.getNombre().toUpperCase().contains(filter.toUpperCase())).toList();
    }

}
