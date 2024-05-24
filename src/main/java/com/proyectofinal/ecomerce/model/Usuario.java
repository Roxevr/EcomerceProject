package com.proyectofinal.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	private int id;
	private String nombre;
	private String nombreUsuario;
	private String passwordUsuario;
	private String telefono;
	private String email;
	private Tipo tipo;
	
	@OneToMany
	private Pedido pedido;
}
