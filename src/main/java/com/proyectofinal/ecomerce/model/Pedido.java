package com.proyectofinal.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    
    @ManyToOne
    private Usuario usuario;
    
    @OneToOne
    private ItemsPedido itemsPedido;
    
    private LocalDate fecha;

    public Pedido() {
    	
    }

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
        this.fecha = LocalDate.now();
    }
    
}
