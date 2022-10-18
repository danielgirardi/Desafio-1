package br.com.desafio.service;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import br.com.desafio.entities.Product;
import br.com.desafio.services.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//daqui pra baixo importei para os testes
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;


import static org.assertj.core.api.Assertions.assertThat;

public class StockTest {


	@Test
	void addProductTest() {
		Stock stock = new Stock();
		stock.addProduct("t0n75ytr", "Teclado Gamer", 236.84, 2, "ESCRITÓRIO");

		assertThat(stock.getProducts()).extracting("code").contains("t0n75ytr");
		assertThat(stock.getProducts()).extracting("name").contains("Teclado Gamer");
		assertThat(stock.getProducts()).extracting(Product::getPrice).contains(236.84);
		assertThat(stock.getProducts()).extracting("quantity").contains(2);
		assertThat(stock.getProducts()).extracting("category").contains("ESCRITÓRIO");
		assertThat(stock.getProducts()).hasSize(1);
	}
}
	/*
	@Test
	void addProductMostruarioTest() {

	Stock stock = new Stock;
	stock.addProductMostruario();



	}

}
/*
    @Test
    void removeProductTest(){

    }
    @Test
    void editProductTest(){

    }
}

	@Test
	public void addProduct (Integer id, String name, Double price, Integer quantity, String category) {

		Assert.assertTrue(true);  //procurar n�o usar assertivas com nega��o, melhor � criar as duas
		Assert.assertTrue(false);

		Assert.assertEquals(0.51234, 0.512, 0.001);
		//assertivas com double ou monet�rio usar (0.00 1) + tipo Integer ou converte int p/ Integer.valueof();
		// Para comparar String usa-se Assert.assertEquals("bola", "bola); OBS: cuidar se as letras tem ma�sculo ou caracteres especiais
		//String com letras e caracteres diferentes p/ comprar usa-se Assert.asserttRUE("bola".EQUALSiGNOREcASE("bola"));


	}

*/



