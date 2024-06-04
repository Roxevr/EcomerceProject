package com.proyectofinal.ecomerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

	@OneToMany(mappedBy = "carrito")
	private List<Producto> productos;

	@OneToOne
	private Usuario usuario;

	public Carrito(LocalDate fechaSalida, LocalDate fechaEntrega, Usuario usuario) {
		super();
		this.fechaSalida = fechaSalida;
		this.fechaEntrega = fechaEntrega;
		this.usuario = usuario;
	}

	public void añadirProductoCarrito(Producto producto) {
		
	}
}
