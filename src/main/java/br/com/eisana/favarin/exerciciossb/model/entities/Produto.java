package br.com.eisana.favarin.exerciciossb.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank //valida se o valor é diferente de vazio
	private String nome;
	
	@Min(0) //O preço deve ser no mínimo 0. não irá aceitar valor negativo
	private double valor;
	
	@Min(0) //O desconto deve ser no mínimo 0. não irá aceitar valor negativo
	@Max(1) //o desconto deve ser no máximo 1.
	private double desconto;
	
	public Produto() {
	
	}	
	
	
	public Produto(String nome, double valor, double desconto) {		
		this.nome = nome;
		this.valor = valor;
		this.desconto = desconto;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}	
	
}
