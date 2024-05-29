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
	public List<Producto> findAll() {
		return productoDao.findAll();
	}

	@Override
	public Optional<Producto> findOne(int id) {
		return productoDao.findById(id);
	}

}
