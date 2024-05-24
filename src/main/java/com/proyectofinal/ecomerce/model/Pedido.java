package com.proyectofinal.ecomerce.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="fecha_salida")
	private LocalDate fechaSalida;
	
	@Column(name="fecha_entrega")
	private LocalDate fechaEntrega;
	
	@OneToMany
	private List<Producto> productos;
	
	@ManyToOne
	private Usuario usuario;
	
	
}
