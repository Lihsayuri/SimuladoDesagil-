package br.edu.insper.desagil.restaurantesimulado;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EstabelecimentoTest {
	private static double DELTA = 0.01;
	private Estabelecimento estabelecimento;
	private List<Integer>codigos;

	@BeforeEach 
	public void setUp() {
		estabelecimento = new Estabelecimento("LingLing");
		codigos = new ArrayList<>();
	}
	
	@Test
	public void tresItensProcessaDois() {
		ItemComum item1 = new ItemComum("Tempurá", 13.50);
		ItemComum item2 = new ItemComum("Yakisoba", 29.50);
		ItemComum item3 = new ItemComum("Udon" , 45.40);
		estabelecimento.cadastra(0, item1);
		estabelecimento.cadastra(1, item2);
		estabelecimento.cadastra(2, item3);
		codigos.add(0);
		codigos.add(1);
		double preco = estabelecimento.processa(codigos);
		assertEquals(43, preco, DELTA);
	}
	
	@Test
	public void DoisItensComboTresItens() {
		ItemComum item1 = new ItemComum("Tempurá", 13.50);
		ItemComum item2 = new ItemComum("Yakisoba", 29.50);
		ItemComum item3 = new ItemComum("Udon" , 45.40);
		ItemComum item4 = new ItemComum("Manju", 10.50);
		ItemComum item5 = new ItemComum("TamagoKakeGohan", 11.50);
		
		estabelecimento.cadastra(1, item1);
		estabelecimento.cadastra(2, item2);
		
		List<ItemComum> itenscombo = new ArrayList<>();
		itenscombo.add(item3);
		itenscombo.add(item4);
		itenscombo.add(item5);
		
		ItemCombo combo1 = new ItemCombo("Jap", 0.8, itenscombo);
		estabelecimento.cadastra(3, combo1);
		
		codigos.add(1);
		codigos.add(2);
		codigos.add(3); 
		
		double preco = estabelecimento.processa(codigos);
		assertEquals(96.92, preco, DELTA);
	}
	

	@Test
	public void UmItemComumDoisCombos() {
		ItemComum item1 = new ItemComum("Tempurá", 13.50);
		ItemComum item2 = new ItemComum("Yakisoba", 29.50);
		ItemComum item3 = new ItemComum("Udon" , 45.40);
		ItemComum item4 = new ItemComum("Manju", 10.50);
		ItemComum item5 = new ItemComum("TamagoKakeGohan", 11.50);
		
		estabelecimento.cadastra(1, item1);

		List<ItemComum> itenscombo1 = new ArrayList<>();
		itenscombo1.add(item3);
		itenscombo1.add(item4);
		itenscombo1.add(item5);
		
		ItemCombo combo1 = new ItemCombo("Jap", 0.8, itenscombo1);
		estabelecimento.cadastra(2, combo1);
		
		List<ItemComum> itenscombo2 = new ArrayList<>();
		itenscombo2.add(item1);
		itenscombo2.add(item2);
		itenscombo2.add(item3);
		
		ItemCombo combo2 = new ItemCombo("Jap2", 0.9, itenscombo2);
		estabelecimento.cadastra(3, combo2);
		
		
		codigos.add(1);
		codigos.add(2);
		codigos.add(3); 
		
		double preco = estabelecimento.processa(codigos);
		assertEquals(146.98, preco, DELTA);
	}
	
}
