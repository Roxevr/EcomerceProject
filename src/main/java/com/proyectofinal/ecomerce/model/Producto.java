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

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;

	@Column(name = "codigo", length = 10, nullable = false, unique = true)
	private String codigo;
	private String cantidad;

	private String nombre;
	private double precio;
	private String imagen;
	private String descripcion;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	public Producto() {

	}

	public Producto(Long idProducto, String codigo, String cantidad, String nombre, double precio, String imagen,
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

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

}
