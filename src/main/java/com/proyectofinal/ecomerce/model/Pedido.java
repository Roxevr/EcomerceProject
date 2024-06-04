package com.proyectofinal.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    
    @ManyToOne
    private Usuario usuario;
    
    @OneToMany
    private List<Producto> productos ;
    
    private LocalDate fecha;

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
        this.fecha = LocalDate.now();
    }
    
}
