package com.proyectofinal.ecomerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ItemsCarrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItemCarrito;
	private int cantidad;

	@OneToOne
	private Carrito carrito;

	@OneToMany(mappedBy = "itemsCarrito")
	private List<Producto> productos;

	public ItemsCarrito() {
	}

	public ItemsCarrito(Carrito carrito, List<Producto> productos, int cantidad) {
		this.carrito = carrito;
		this.productos = productos;
		this.cantidad = cantidad;
	}
	
	public ItemsCarrito(Long idItemCarrito, int cantidad, Carrito carrito, List<Producto> productos) {
		super();
		this.idItemCarrito = idItemCarrito;
		this.cantidad = cantidad;
		this.carrito = carrito;
		this.productos = productos;
	}

	public Long getIdItemCarrito() {
		return idItemCarrito;
	}

	public void setIdItemCarrito(Long idItemCarrito) {
		this.idItemCarrito = idItemCarrito;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	

}
