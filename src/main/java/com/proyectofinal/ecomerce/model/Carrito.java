package com.proyectofinal.ecomerce.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrito;

	@Column(name = "fecha_salida")
	private LocalDate fechaSalida;

	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;

	@OneToOne()
	private ItemsCarrito itemsCarrito;

	@OneToOne
	private Usuario usuario;

	public Carrito() {
	}

	public Carrito(LocalDate fechaSalida, LocalDate fechaEntrega, ItemsCarrito itemsCarrito, Usuario usuario) {
		super();
		this.fechaSalida = fechaSalida;
		this.fechaEntrega = fechaEntrega;
		this.itemsCarrito = itemsCarrito;
		this.usuario = usuario;
	}

	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public ItemsCarrito getItemsCarrito() {
		return itemsCarrito;
	}

	public void setItemsCarrito(ItemsCarrito itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carrito [idCarrito=");
		builder.append(idCarrito);
		builder.append(", fechaSalida=");
		builder.append(fechaSalida);
		builder.append(", fechaEntrega=");
		builder.append(fechaEntrega);
		builder.append(", itemsCarrito=");
		builder.append(itemsCarrito);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("]");
		return builder.toString();
	}

}
