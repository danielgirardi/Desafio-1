package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import entities.Product;
import entities.Stock;

public class Program{
	
	private Stock stock = new Stock();

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);	
		Scanner sc = new Scanner(System.in);
		LocalDate dataAtual = LocalDate.now();
		Program program = new Program();
		
		int answer = 0;
		boolean exit = false;
		
		program.readDocument(); 
		
		
		do {
			System.out.println("Entre as opções abaixo, escolha apenas uma: ");
			System.out.println("1) Adicionar novo produto");
			System.out.println("2) Editar produto");
			System.out.println("3) Remover produto");
			System.out.println("4) Mostruário ");
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
		Random gerador = new Random();
		int id = gerador.nextInt();
		System.out.println("Nome do produto: ");
		String name = sc.next();
		System.out.println("Preço do produto: ");
		double price = sc.nextDouble();
		System.out.println("Quantitdade do produto: ");
		int quantity = sc.nextInt();
		System.out.println("Categoria do produto: ");
		String category = sc.next();
		
		
		stock.addProduct(id, name, price, quantity, category);
	}
	
	private void editProduct (Scanner sc) {
			
		stock.printProducts();
		System.out.println();
		System.out.println("Qual o ID do produto que deseja editar? ");
		int id = sc.nextInt();							
		System.out.println("Digite o nome do produto ");
		String name = sc.next();
		System.out.println("Preço do produto: ");
		double price = sc.nextDouble();
		System.out.println("Quantitdade do produto: ");
		int quantity = sc.nextInt();
		System.out.println("Categoria do produto: ");
		String category = sc.next();
		
		stock.editProducts(id, name, price, quantity, category);
	
	}
	
	private void removeProduct (Scanner sc) {
		if ( stock.getProducts().size()==0) {
			System.out.println("Impossível remover (lista vazia)");
		} else {
			stock.printProducts();
			System.out.println();
			System.out.println("Qual o ID do produto que deseja remover? ");
			int id = sc.nextInt();
			
			stock.removeProduct(id);
		}
	}
	
	
	public void readDocument() throws IOException {
		
		Locale.setDefault(Locale.US);
		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\estoque.csv";
		
		Reader reader = Files.newBufferedReader(Paths.get(path));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

		List<String[]> productList = csvReader.readAll();
		for (String[] product : productList) {
			
			Integer id = Integer.parseInt(product[0]);
			String name = product[1];
			String category = product[2];
			Double price = Double.parseDouble(product[3]);
			Integer qte = Integer.parseInt(product[4]);
						
			this.stock.addProduct(id, name, price, qte, category); 
		}
		
	}
			
	public void readDocumentMostruario() throws IOException {//iniciei aqui a leitura do mostruario_fabrica
		
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

	}
	
	
	public void writeDocument () {
		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\estoque.txt";	
		
		try { 
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
					
			String header = new String ("Id,Nome,Categoria,Preco,Quantidade");
			bw.write(header);
			bw.newLine();
			for (Product product : stock.getProducts()) {
				bw.write(String.valueOf(product.getId()));
				bw.write(",");
				bw.write(product.getName());
				bw.write(",");
				bw.write(product.getCategory());
				bw.write(",");
				bw.write( String.valueOf(product.getPrice()));
				bw.write(",");
				bw.write(String.valueOf(product.getQuantity()));
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}






