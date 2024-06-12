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


@Entity
@Table(name = "carritos")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrito;

	@Temporal(value = TemporalType.DATE)
	private LocalDate fechaSalida;

	@Temporal(value = TemporalType.DATE)
	private LocalDate fechaEntrega;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Producto> productos = new HashSet<>();
	
	

	public Carrito() {
	}

	public Carrito(Long idCarrito, LocalDate fechaSalida, LocalDate fechaEntrega, Usuario usuario) {
		super();
		this.idCarrito = idCarrito;
		this.fechaSalida = fechaSalida;
		this.fechaEntrega = fechaEntrega;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}