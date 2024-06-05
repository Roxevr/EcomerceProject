package com.proyectofinal.ecomerce.model;

import java.util.HashSet;
import java.util.Set;

import com.proyectofinal.ecomerce.model.enums.Tipo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private Tipo tipo;
    
    private String nombre;
    private String email;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private Set<Pedido> pedidos = new HashSet<>();
}

