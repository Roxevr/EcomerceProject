package com.proyectofinal.ecomerce.model;

import java.time.LocalDate;
import java.util.Set;

import com.proyectofinal.ecomerce.model.util.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private LocalDate fechaCreacion;

	private Double prize;

	private Status estado = Status.EN_ENTREGA;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pedido_id")
	private Set<ItemPedido> itemsPedido;
	
	
	public void addItem(ItemPedido item) {
		itemsPedido.add(item);
	}

	/*
	 * Si el estado esta finalizado devuelve true, sino false
	 */
	public boolean isEntregado() {
		return estado == Status.FINALIZADO;
	}

	public Double calcularPrecioTotal() {
		double total = 0;

		for (ItemPedido item : itemsPedido) {
			total += item.getPrize();
		}
		return total;
	}
}
