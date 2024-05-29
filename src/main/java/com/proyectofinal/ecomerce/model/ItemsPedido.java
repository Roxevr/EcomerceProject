package com.proyectofinal.ecomerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ItemsPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemPedido;
    
    @OneToOne
    private Pedido pedido;
    
    @OneToMany(mappedBy = "itemsPedido")
    private List<Producto> productos;
    
    private int cantidad;

    public ItemsPedido() {}

    public ItemsPedido(Pedido pedido, List<Producto> productos, int cantidad) {
        this.pedido = pedido;
        this.productos = productos;
        this.cantidad = cantidad;
    }
}

