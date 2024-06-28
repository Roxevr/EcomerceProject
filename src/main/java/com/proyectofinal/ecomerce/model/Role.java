package com.proyectofinal.ecomerce.model;

import java.io.Serializable;
import java.util.List;

import com.proyectofinal.ecomerce.model.util.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable{	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true)
	private Tipo name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	private static final long serialVersionUID = 1L;
}
