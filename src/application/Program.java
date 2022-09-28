package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import entities.Product;
import entities.Stock;

public class Program{
	
	private Stock stock = new Stock();

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);	
		Scanner sc = new Scanner(System.in);	
		Program program = new Program();
		
		int answer = 0;
		boolean exit = false;
		
		program.readDocument(); 
		program.readDocumentMostruario();
		
		do {
			System.out.println("Entre as op��es abaixo, escolha apenas uma: ");
			System.out.println("1) Adicionar novo produto");
			System.out.println("2) Editar produto");
			System.out.println("3) Remover produto");
			System.out.println("4) Mostru�rio ");
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
					System.out.println("Um momento, processando o mostru�rio!");
					program.readDocumentMostruario();
					//chamar mostru�rio
					break;
					
				case 5:
					System.out.println("At� a pr�xima, obrigado!");
					program.writeDocument();
					exit = true;
					break;
					
				default:
					System.out.println("Op��o inv�lida, digite novamente!");
					
			}
		} while (!exit); 
			
		sc.close();
	}
	
	private void addInStock(Scanner sc) {
		Random gerador = new Random();
		int id = gerador.nextInt();
		System.out.println("Nome do produto: ");
		String name = sc.next();
		System.out.println("Pre�o do produto: ");
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
		System.out.println("Pre�o do produto: ");
		double price = sc.nextDouble();
		System.out.println("Quantitdade do produto: ");
		int quantity = sc.nextInt();
		System.out.println("Categoria do produto: ");
		String category = sc.next();
		
		stock.editProducts(id, name, price, quantity, category);
	
	}
	
	private void removeProduct (Scanner sc) {
		if ( stock.getProducts().size()==0) {
			System.out.println("Imposs�vel remover (lista vazia)");
		} else {
			stock.printProducts();
			System.out.println();
			System.out.println("Qual o ID do produto que deseja remover? ");
			int id = sc.nextInt();
			
			stock.removeProduct(id);
		}
	}
		
	public void readDocument() {
	
		Locale.setDefault(Locale.US);
		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\estoque.txt"; 
		
		
		try (BufferedReader br = new BufferedReader (new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) { 
				String[] vect = line.split(",");
				Integer id = Integer.parseInt(vect[0]);
				String name = vect[1];
				String category = vect[2];
				Double price = Double.parseDouble(vect[3]);
				Integer qte = Integer.parseInt(vect[4]);
							
				this.stock.addProduct(id, name, price, qte, category); 
				
				line = br.readLine();
			}
	}	
		catch (IOException e) {
			System.out.println("Erros: " + e.getMessage());
		}
		
	}
	
	public void readDocumentMostruario() {//iniciei aqui a leitura do mostruario_fabrica
		
		Locale.setDefault(Locale.US);
		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\mostruario_fabrica.txt";
		
	try (BufferedReader br = new BufferedReader (new FileReader(path))) {
				
				String line = br.readLine();
				line = br.readLine();
				while (line != null) { 
					
					String[] vect = line.split(",");
					String codigo = vect[0]; //tem letras e n�meros, qual TIPO eu coloco em c�digo
					Integer codigoBarra = Integer.parseInt(vect[1]);
					Integer serie = Integer.parseInt(vect[2]);
					String name = vect[3];
					String description = vect[4];
					String category = vect[5];
					Double price = Double.parseDouble(vect[6]);//valor bruto (no arquivo consta como valor bruto)
					Double tax = Double.parseDouble(vect[7]);
					Integer manufacturingDate = Integer.parseInt(vect[8]);
					Integer validationDate = Integer.parseInt(vect[9]);
					String color = vect[10];
					String material = vect[11];
					//n�o consta quantidade no estoque   Integer qte = Integer.parseInt(vect[4]); 
					
					
					
							//criar novo m�todo para receber esses par�metros	
					this.stock.addProduct(codigo, codigoBarra, serie, name, description, category, price, tax, manufacturingDate, validationDate, color, material); //aqui preciso alterar os par�metros (acho eu)
					
					line = br.readLine();
				}
		}	
			catch (IOException e) {
				System.out.println("Erros: " + e.getMessage());
			}
			
		}
		
	}
	
	public void writeDocument () {
		String path = "C:\\Daniel Girardi\\Projetos\\Desafio 1\\estoque.txt";	
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){ 
			
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






