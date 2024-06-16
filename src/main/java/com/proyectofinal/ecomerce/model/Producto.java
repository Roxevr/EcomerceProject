package com.proyectofinal.ecomerce.model;

import com.proyectofinal.ecomerce.model.enums.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;

	@Column(name = "codigo", length = 10, nullable = false, unique = true)
	private String codigo;
	private Integer cantidad;

	private String nombre;
	private Double precio;
	private String imagen;
	private String descripcion;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	

	public Producto() {
	}
	
	public Producto(Long idProducto, String codigo, int cantidad, String nombre, double precio, String imagen,
			String descripcion, Categoria categoria) {
		super();
		this.idProducto = idProducto;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}


}
