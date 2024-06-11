package com.proyectofinal.ecomerce.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrito;

	@Column(name = "fecha_salida")
	private LocalDate fechaSalida;

	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;

	@OneToOne
	private Usuario usuario;

	@OneToMany
	@JoinColumn(name = "producto_id")
	private Set<Producto> productos = new HashSet<>();
}
