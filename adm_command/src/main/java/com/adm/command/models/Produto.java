package com.adm.command.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Produto {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false)
	    private Double value;
	    
	    @Column(nullable = false)
	    private int qtdItens;

	   
	    
	    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	    private Item item;

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

		public int getQtdItens() {
			return qtdItens;
		}

		public void setQtdItens(int qtdItens) {
			this.qtdItens = qtdItens;
		}

		

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		@Override
		public String toString() {
			return "Produto [id=" + id + ", value=" + value + ", qtdItens=" + qtdItens 
					+ ", item=" + item + "]";
		}
	
	    
	    
}
