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
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "carrito_id")
	private Set<ItemCarrito> itemsCarrito;

	public Carrito() {
	}

	public Carrito(User user) {
		this.user = user;
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
