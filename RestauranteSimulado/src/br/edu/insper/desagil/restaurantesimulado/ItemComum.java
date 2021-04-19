package br.edu.insper.desagil.restaurantesimulado;

public class ItemComum extends Item {
	private double preco;

	public ItemComum(String nome, double preco) {
		super(nome);
		this.preco = preco;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}
	
}


