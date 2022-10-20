package br.com.desafio.service;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
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
	void addProductWithSucessTest() {
		Stock stock = new Stock();
		stock.addProduct("abcd1234", "Teclado Gamer", 4.99, 2, "teste");

		assertThat(stock.getProducts()).extracting("name").contains("Teclado Gamer");
		assertThat(stock.getProducts()).extracting("code").contains("abcd1234");
		assertThat(stock.getProducts()).extracting("price").contains(4.99);
		assertThat(stock.getProducts()).extracting("quantity").contains(2);
		assertThat(stock.getProducts()).extracting("category").contains("teste");
		assertThat(stock.getProducts()).hasSize(1);
	}
	@Test
	void addProductNotSucessTest() {
		Stock stock = new Stock();
		stock.addProduct("abcd1234", "Teclado Gamer", 4.99, 2, "teste");

		assertThat(stock.getProducts()).extracting("name").contains("vaso");
		assertThat(stock.getProducts()).extracting("code").contains("rg5454");
		assertThat(stock.getProducts()).extracting("price").contains(5.99);
		assertThat(stock.getProducts()).extracting("quantity").contains(3);
		assertThat(stock.getProducts()).extracting("category").contains("teste2");
		assertThat(stock.getProducts()).hasSize(1);
	}
	@Test
	void removeProductWithSucessTest() {
		Stock stock = new Stock();
		stock.addProduct("987asd", "copo", 9.80, 10, "casa");
		assertThat(stock.getProducts()).hasSize(1);

		stock.removeProduct("987asd");

		assertThat(stock.getProducts()).hasSize(0);
	}
	@Test
	void removeProductNotSucessTest() {

		Stock stock = new Stock();
		stock.addProduct("987asd", "copo", 9.80, 10, "casa");
		assertThat(stock.getProducts()).hasSize(1);

		stock.removeProduct("sfdgr57");

		assertThat(stock.getProducts()).hasSize(1);
	}
	@Test
	void editProductWithSucessTest() {
		Stock stock = new Stock();
		stock.addProduct("qwer1234", "jaqueta", 15.99, 23, "teste2");

		stock.editProducts("qwer1234", "mesa", 149.99, 5, "teste3");

		assertThat(stock.getProducts()).extracting("name").contains("mesa");
		assertThat(stock.getProducts()).extracting("code").contains("qwer1234");
		assertThat(stock.getProducts()).extracting("price").contains(149.99);
		assertThat(stock.getProducts()).extracting("quantity").contains(5);
		assertThat(stock.getProducts()).extracting("category").contains("teste3");
		assertThat(stock.getProducts()).extracting("name").doesNotContain("jaqueta");
		assertThat(stock.getProducts()).extracting("price").doesNotContain(15.99);
		assertThat(stock.getProducts()).extracting("quantity").doesNotContain(5);
		assertThat(stock.getProducts()).extracting("category").doesNotContain("teste2");
		assertThat(stock.getProducts()).hasSize(1);
	}
	@Test
	void editProductNotSucessTest() {
		Stock stock = new Stock();
		stock.addProduct("qwer1234", "jaqueta", 15.99, 23, "teste2");

		stock.editProducts("hds3h", "mesa", 149.99, 5, "teste3");

		assertThat(stock.getProducts()).extracting("code").contains("qwer1234");
		assertThat(stock.getProducts()).extracting("name").contains("jaqueta");
		assertThat(stock.getProducts()).extracting("price").contains(15.99);
		assertThat(stock.getProducts()).extracting("quantity").contains(23);
		assertThat(stock.getProducts()).extracting("category").contains("teste2");
		assertThat(stock.getProducts()).extracting("name").doesNotContain("mesa");
		assertThat(stock.getProducts()).extracting("price").doesNotContain(22.99);
		assertThat(stock.getProducts()).extracting("quantity").doesNotContain(6);
		assertThat(stock.getProducts()).extracting("category").doesNotContain("teste3");
		assertThat(stock.getProducts()).hasSize(1);
	}
	@Test
	void totalPriceWithSucessTest() {
		Stock stock = new Stock();
		assertEquals(stock.totalPrice(120.99, 35), 236.84);
	}
	@Test
	void totalPriceNotSucessTest() {
		Stock stock = new Stock();
		assertEquals(stock.totalPrice(99.0, 20), 153.50);
	}
	@Test
	void addProductWithSucessTest2() {
		Stock stock = new Stock();
		stock.addProduct("abcd1234", "notebook", 5.000, 4, "teste4", Long.valueOf(62993636), "4/2019",
				"computador portatil", 35.0, "n/a", "n/a", "preto", "plastico");

		assertThat(stock.getProducts()).extracting("code").contains("abcd1234");
		assertThat(stock.getProducts()).extracting("name").contains("notebook");
		assertThat(stock.getProducts()).extracting("price").contains(5.000);
		assertThat(stock.getProducts()).extracting("quantity").contains(4);
		assertThat(stock.getProducts()).extracting("category").contains("teste4");
		assertThat(stock.getProducts()).extracting("codigoBarra").contains(Long.valueOf(62993636));
		assertThat(stock.getProducts()).extracting("serie").contains("4/2019");
		assertThat(stock.getProducts()).extracting("description").contains("computador portatil");
		assertThat(stock.getProducts()).extracting("tax").contains(35.0);
		assertThat(stock.getProducts()).extracting("manufacturingDate").contains("n/a");
		assertThat(stock.getProducts()).extracting("validationDate").contains("n/a");
		assertThat(stock.getProducts()).extracting("color").contains("preto");
		assertThat(stock.getProducts()).extracting("material").contains("plastico");
		assertThat(stock.getProducts()).hasSize(1);
	}
	@Test
	void addProductNotSucessTest2() {
		Stock stock = new Stock();
		stock.addProduct("abcd1234", "notebook", 5.000, 4, "teste4", Long.valueOf(6299363), "4/2019",
				"computador portatil", 35.0, "n/a", "n/a", "preto", "plastico");

		assertThat(stock.getProducts()).extracting("code").contains("rurtu654542");
		assertThat(stock.getProducts()).extracting("name").contains("lata");
		assertThat(stock.getProducts()).extracting("price").contains(39.0);
		assertThat(stock.getProducts()).extracting("quantity").contains(10);
		assertThat(stock.getProducts()).extracting("category").contains("teste5");
		assertThat(stock.getProducts()).extracting("codigoBarra").contains(Long.valueOf(5469879));
		assertThat(stock.getProducts()).extracting("serie").contains("5/2020");
		assertThat(stock.getProducts()).extracting("description").contains("casa");
		assertThat(stock.getProducts()).extracting("tax").contains(50.0);
		assertThat(stock.getProducts()).extracting("manufacturingDate").contains("10/10/2020");
		assertThat(stock.getProducts()).extracting("validationDate").contains("09/08/2030");
		assertThat(stock.getProducts()).extracting("color").contains("transparente");
		assertThat(stock.getProducts()).extracting("material").contains("vidro");
		assertThat(stock.getProducts()).hasSize(1);
	}
	@Test
	void addProductMostruarioWithSucessTest() {
		Stock stock = new Stock();
		stock.addProductMostruario("4653rhhj", Long.valueOf(4645313), "1/2020", "ferro", "teste4", "casa",
				68.90, 1.5, "27/02/2020", "n/a", "azul", "plastico");

		assertThat(stock.getProductMostruario()).extracting("codigo").contains("4653rhhj");
		assertThat(stock.getProductMostruario()).extracting("codigoBarra").contains(Long.valueOf(4645313));
		assertThat(stock.getProductMostruario()).extracting("serie").contains("1/2020");
		assertThat(stock.getProductMostruario()).extracting("name").contains("ferro");
		assertThat(stock.getProductMostruario()).extracting("description").contains("teste4");
		assertThat(stock.getProductMostruario()).extracting("category").contains("casa");
		assertThat(stock.getProductMostruario()).extracting("price").contains(68.90);
		assertThat(stock.getProductMostruario()).extracting("tax").contains(1.5);
		assertThat(stock.getProductMostruario()).extracting("manufacturingDate").contains("27/02/2020");
		assertThat(stock.getProductMostruario()).extracting("validationDate").contains("n/a");
		assertThat(stock.getProductMostruario()).extracting("color").contains("azul");
		assertThat(stock.getProductMostruario()).extracting("material").contains("plastico");
		assertThat(stock.getProductMostruario()).hasSize(1);
	}
	@Test
	void isProductInStockWithSucessTest() {

		Stock stock = new Stock();
		stock.addProduct("ktr4557", "carregador", 19.99, 7, "eletronico");
		assertTrue(stock.isProductInStock("ktr4557"));
	}
	@Test
	void isProductInStockNotSucessTest() {

		Stock stock = new Stock();
		stock.addProduct("ktr4557", "carregador", 19.99, 7, "eletronico");
		assertFalse(stock.isProductInStock("rhrjt5465"));
	}
}

