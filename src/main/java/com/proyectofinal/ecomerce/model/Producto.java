package com.proyectofinal.ecomerce.model;

import com.proyectofinal.ecomerce.model.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor()
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;

	private String nombre;
	private double precio;
	private String imagen;
	private String descripcion;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productos_carrito")
	private Carrito carrito;


	public Producto(String nombre, double precio, String imagen, String descripcion,
			Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

}
