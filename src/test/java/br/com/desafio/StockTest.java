package br.com.desafio;

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

import static org.assertj.core.api.Assertions;

class StockTest {

	Stock stock = new Stock();
	Product product = new Product();
	@Test
	void addProductTest() {
/*
	assertThat(product.getName(), contains(
		hasProperty("name", is("Teclado Gamer")),
		hasProperty("name", is("Café Solúvel South")));


		Assertions.assertThat(product.getProduct()).hasSize(2).extracting(Product::getName).containsExactlyInAnyOrder("Teclado Gamer", "Café Solúvel South");
*/
	//stock.addProduct();

		// assertEquals(2,1 + 1);

	}
	/*
	@Test
	public void addProduct (Integer id, String name, Double price, Integer quantity, String category) {

		Assert.assertTrue(true);  //procurar n�o usar assertivas com nega��o, melhor � criar as duas
		Assert.assertTrue(false);

		Assert.assertEquals(0.51234, 0.512, 0.001);
		//assertivas com double ou monet�rio usar (0.00 1) + tipo Integer ou converte int p/ Integer.valueof();
		// Para comparar String usa-se Assert.assertEquals("bola", "bola); OBS: cuidar se as letras tem ma�sculo ou caracteres especiais
		//String com letras e caracteres diferentes p/ comprar usa-se Assert.asserttRUE("bola".EQUALSiGNOREcASE("bola"));

		//cenario


		//acao


		//verificacao
		Assert.assertTrue()
	}

	@Rule
	public ErrorCollector error = new ErrorColletctor();

	//verica��o do ErrosColletctor �: @Rule + error.checkThat(locacao.getValor(), is(equalTo(6.0)));

	@Test
	public void addProductMostruari() {
		//cenario


		//acao


		//verificacao
	}

	@Test
	public void editProduct() {
		//cenario


		//acao


		//verificacao
	}

	@Test
	public void removeProduct() {
		//cenario


		//acao


		//verificacao
	}

	@Test
	public void printProducts () {
		//cenario


		//acao


		//verificacao
	}

	@Test
	public void addProductfromMostruario() {
		//cenario


		//acao


		//verificacao
	}

	@Test
	public void (double price, double tax) {
		//cenario


		//acao


		//verificacao
	}

}
	*/



}
