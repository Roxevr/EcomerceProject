package com.proyectofinal.ecomerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
@Entity
public class Almacen {

	@Id
	private String cod_Producto;
	private Long cantidad;
}
