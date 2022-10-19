package br.com.desafio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import br.com.desafio.entities.Product;
import br.com.desafio.services.Stock;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class Program{
	
	private Stock stock = new Stock();


	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);	
		Scanner sc = new Scanner(System.in);
		Program program = new Program();
		
		int answer = 0;
		boolean exit = false;
		
		program.readDocument(); 
		
		
		do {
			System.out.println("Entre as opções abaixo, escolha apenas uma: ");
			System.out.println("1) Adicionar novo produto");
			System.out.println("2) Editar produto");
			System.out.println("3) Remover produto");
			System.out.println("4) Importar produtos do mostruário ");
			System.out.println("5) Sair");
			
			answer = sc.nextInt();
			
			switch (answer) {
				case 1:
					System.out.println("Adicionar no estoque ");	
					program.addInStock(sc);
					break;
					
				case 2:
					System.out.println("Editar produto no estoque");
					program.editProduct(sc);
					break;
				
				case 3:
					System.out.println("Remover do estoque");
					program.removeProduct(sc);
					break;
					
				case 4:
					System.out.println("Um momento, processando o mostruário!");
					program.readDocumentMostruario();
					break;
					
				case 5:
					System.out.println("Até a próxima, obrigado!");
					program.writeDocument();
					exit = true;
					break;
					
				default:
					System.out.println("Opção inválida, digite novamente!");
					
			}
		} while (!exit); 
			
		sc.close();
	}
	
	private void addInStock(Scanner sc) {

		stock.printProducts();
		System.out.println();
	//inserir opção de sair a qualquer momento
		System.out.println("Deseja adicionar um produto da lista acima? s/n");
		char answer = sc.next().charAt(0);
		if (answer != 's') return;

		String code = Program.getRandomCode();
		System.out.println("Nome do produto: ");
		String name = sc.next();
		System.out.println("Preço do produto: ");
		double price = sc.nextDouble();
		System.out.println("Quantitdade do produto: ");
		int quantity = sc.nextInt();
		System.out.println("Categoria do produto: ");
		String category = sc.next();
		
		
		stock.addProduct(code, name, price, quantity, category);
	}

	private static String getRandomCode () {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for( int i = 0; i < 8; i++ ) {
			index = random.nextInt( alphabet.length() );
			armazenaChaves += alphabet.substring( index, index + 1 );
		}
		return armazenaChaves;

	}

	private void editProduct (Scanner sc) {

		stock.printProducts();
		System.out.println();

		System.out.println("Deseja editar um produto da lista acima? s/n");
		char answer = sc.next().charAt(0);
		if (answer != 's') return;

		System.out.println("Qual o código do produto que deseja editar? ");
		String code = sc.next();

		if (stock.isProductInStock(code)){

			System.out.println("Digite o nome do produto ");
			String name = sc.next();
			System.out.println("Preço do produto: ");
			double price = sc.nextDouble();
			System.out.println("Quantitdade do produto: ");
			int quantity = sc.nextInt();
			System.out.println("Categoria do produto: ");
			String category = sc.next();

			stock.editProducts(code, name, price, quantity, category);
		}
		else{
			System.out.println("Este produto não existe no estoque!");
		}

	}
	
	private void removeProduct (Scanner sc) {
		if (stock.getProducts().size()==0) {
			System.out.println("Impossível remover (lista vazia)");
		} else {
			stock.printProducts();
			System.out.println();

			System.out.println("Deseja remover um produto da lista acima? s/n");
			char answer = sc.next().charAt(0);
			if (answer != 's') return;

			System.out.println("Qual o código do produto que deseja remover? ");
			String code = sc.next();
			
			stock.removeProduct(code);
		}
	}
	
	public void readDocument() throws IOException {
		
		Locale.setDefault(Locale.US);
		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\estoque.csv";
		
		FileReader fileReader = new FileReader(path);
		CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();

		List<String[]> productList = csvReader.readAll();
		for (String[] product : productList) {

			String codigo = product[0];
			Long codigoBarra = Long.parseLong(product[1]);
			String serie = (product[2]);
			String name = product[3];
			String description = product[4];
			String category = product[5];
			Double price = Double.parseDouble(product[6].replace(",", "."));
			Double tax = Double.parseDouble(product[7].replace(",", "."));
			String manufacturingDate = product[8];
			String validationDate = product[9];
			String color = product[10];
			String material = product[11];
			Integer quantity = Integer.parseInt(product[12]);
						
			this.stock.addProduct( codigo, name, price, quantity, category, codigoBarra,
			 serie, description, tax, manufacturingDate, validationDate, color, material);
		}
		
	}
			
	public void readDocumentMostruario() throws IOException {
		
		Locale.setDefault(Locale.US);
		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\mostruario_fabrica.csv";

		Reader reader = Files.newBufferedReader(Paths.get(path));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

		List<String[]> mostruarioList = csvReader.readAll();
		for (String[] product : mostruarioList) {

			String codigo = product[0]; 
			Long codigoBarra = Long.parseLong(product[1]);
			String serie = (product[2]);
			String name = product[3];
			String description = product[4];
			String category = product[5];
			Double price = Double.parseDouble(product[6].replace(",", "."));
			Double tax = Double.parseDouble(product[7].replace(",", "."));
			String manufacturingDate = product[8]; 
			String validationDate = product[9];
			String color = product[10];
			String material = product[11];

			this.stock.addProductMostruario(codigo, codigoBarra, serie, name, description, category, price, tax, manufacturingDate, validationDate, color, material);
		}
		
		stock.addProductfromMostruario();

	}
	
	public void writeDocument() { 

		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\estoque.csv";

		File file = new File(path);
		try {
			
			FileWriter outputfile = new FileWriter(file);

			CSVWriter writer = new CSVWriter(outputfile);

			String[] header = { "Código", "Código de barras", "Serie", "Nome", "descrição", "Categoria",
					"Valor Bruto", "Imposto (%)", "Data de Fabricação", "Data de Validade", "Cor", "Material", "Quantity" };
			writer.writeNext(header);

			for (Product product : stock.getProducts()) {
				String[] productparameters = new String[13];

				productparameters[0] = String.valueOf(product.getCode());
				productparameters[1] = String.valueOf(product.getCodigoBarra());
				productparameters[2] = (product.serie);
				productparameters[3] = (product.getName());
				productparameters[4] = (product.description);
				productparameters[5] = (product.getCategory());
				productparameters[6] = (String.valueOf(product.getPrice()));
				productparameters[7] = String.valueOf(product.getTax());
				productparameters[8] = (product.manufacturingDate);
				productparameters[9] = (product.getValidationDate());
				productparameters[10] = (product.getColor());
				productparameters[11] = (product.getMaterial());
				productparameters[12] = String.valueOf(product.getQuantity());

				writer.writeNext(productparameters);
			}

			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}






