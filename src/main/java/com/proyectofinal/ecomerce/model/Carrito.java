package com.proyectofinal.ecomerce.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "carrito")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrito;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Producto> productos = new HashSet<>();

	public Carrito() {
	}
	
	public Carrito (Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void agregarProducto(Producto producto) {
		if(producto != null) {
			productos.add(producto);
		}
		
	}


}
