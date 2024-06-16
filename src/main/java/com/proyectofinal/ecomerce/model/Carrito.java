package com.proyectofinal.ecomerce.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "carritos")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrito;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "carrito_id")
	private Set<ItemCarrito> itemsCarrito;

	public Carrito() {
	}

	public Carrito(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double calcularTotal() {
		double total = 0;

		for (ItemCarrito item : itemsCarrito) {
			total += item.calcularPrecio();
		}

		return total;
	}

	public void agregarProducto(ItemCarrito item) {
		itemsCarrito.add(item);

	}

}
