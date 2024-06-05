package com.proyectofinal.ecomerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.ecomerce.model.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Long>{

}
