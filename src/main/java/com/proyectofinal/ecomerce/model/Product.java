package com.proyectofinal.ecomerce.model;

import com.proyectofinal.ecomerce.model.util.Categoria;

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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10, nullable = false, unique = true)
	private String code;
	
	private Integer amount;

	private String name;
	private Double prize;
	private String image;
	private String description;
	@Enumerated(EnumType.STRING)
	private Categoria category;
	

	public Product() {
	}
	
	public Product(Long id, String code, int amount, String name, double prize, String image,
			String description, Categoria category) {
		super();
		this.id = id;
		this.code= code;
		this.amount= amount;
		this.name = name;
		this.prize = prize;
		this.image = image;
		this.description = description;
		this.category = category;
	}


}
