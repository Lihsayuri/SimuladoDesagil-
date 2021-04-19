package br.edu.insper.desagil.restaurantesimulado;

public abstract class Item {
	private String nome;

	public Item(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public abstract double getPreco(); 

}

