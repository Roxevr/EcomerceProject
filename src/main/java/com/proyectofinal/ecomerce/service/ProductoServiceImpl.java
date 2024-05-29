package com.proyectofinal.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinal.ecomerce.dao.ProductoDao;
import com.proyectofinal.ecomerce.model.Producto;

public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public List<Producto> finAll() {
		return productoDao.findAll();
	}

	@Override
	public Optional<Producto> finOne(int id) {
		return productoDao.findById(id);
	}

}
