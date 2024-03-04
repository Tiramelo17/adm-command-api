package com.adm.command.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Pedido {
	
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    
    @Column(nullable = false)
    private Double value;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Produto> produtos;
    
  
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private User atendente;
    
    private int numMesa;
    
    private Boolean pedidoAtivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public User getAtendente() {
		return atendente;
	}

	public void setAtendente(User atendente) {
		this.atendente = atendente;
	}

	public boolean isPedidoAtivo() {
		return pedidoAtivo;
	}

	public void setPedidoAtivo(boolean pedidoAtivo) {
		this.pedidoAtivo = pedidoAtivo;
	}

	
	
}
