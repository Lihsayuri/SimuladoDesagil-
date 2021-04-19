package br.edu.insper.desagil.restaurantesimulado;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estabelecimento {
	private String nome;
	private Map<Integer, Item> itens;
	
	public Estabelecimento(String nome) {
		this.nome = nome;
		this.itens = new HashMap<>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void cadastra(int codigo, Item item) {
		this.itens.put(codigo, item);
	}
	
	public double processa(List<Integer> codigos) {
		double soma = 0;
		for ( int codigo : codigos) {
			soma+= this.itens.get(codigo).getPreco();
		}
		 return soma;
	}
	
	//Possui um m�todo que recebe uma lista de c�digos e devolve a soma dos pre�os dos itens correspondentes.
}



