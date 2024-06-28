package com.proyectofinal.ecomerce.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.model.Product;
import com.proyectofinal.ecomerce.model.dao.ProductoDao;

import jakarta.transaction.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional
	public void save(Product producto) {
        productoDao.save(producto);
    }

	@Override
    public Product findByCodigo(String codigo) {
        return productoDao.findByCodigo(codigo).orElse(null);
    }
	
	@Override
	public Product findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }
	
	@Override
	@Transactional
	public void update(Product producto, int eliminarStock) {
		productoDao.findById(producto.getId()).stream().findFirst().ifPresent(p ->{
			p.setAmount(p.getAmount() - eliminarStock);
		});
	}

	@Override
    public List<Product> findAll(String filter) {
		if(filter == null || filter.isBlank()  ) {
			return productoDao.findAll();
		}
        return productoDao.findAll().stream().filter(p -> p.getName().toUpperCase().contains(filter.toUpperCase())).toList();
    }

}
