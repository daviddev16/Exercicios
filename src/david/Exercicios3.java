package david;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicios3 {

	public static final int EXIBIR_LISTA = 1;
	public static final int REGISTRAR_CLIENTE = 2;
	public static final int FECHAR = -1;

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();

		int action = FECHAR; 
		do {

			System.out.println("Digite \"exibir\" para mostrar a lista de clientes ou \"registrar\" para registrar um cliente.");
			System.out.println("Para fechar, basta não digitar nada.");

			String selecionar = scanner.nextLine().trim();

			if(selecionar.equalsIgnoreCase("exibir")) {
				action = EXIBIR_LISTA;
			}else if(selecionar.equalsIgnoreCase("registrar")) {
				action = REGISTRAR_CLIENTE;
			}else {
				action = FECHAR;
			}

			switch(action) {

			case EXIBIR_LISTA:
				exibirLista(clientes);
				continue;

			case REGISTRAR_CLIENTE:
				registrar(scanner, clientes);
				continue;
			}

		}while(action != FECHAR);

	}

	public static void exibirLista(List<Cliente> clientes) {
		System.out.println("======================");

		if(clientes.isEmpty()) {
			System.out.println("Não há nenhum cliente.");
		}else {
			clientes.forEach(System.out::println);
		}
		System.out.println("======================");
	}

	public static void registrar(Scanner mainScanner, List<Cliente> clientes) {

		if(clientes == null) return;

		boolean registrarNovoCliente = false;

		do {

			System.out.println("======================");
			System.out.println("Registar novo cliente:");

			System.out.println("Nome : ");
			String nomeInput = mainScanner.nextLine().trim();

			System.out.println("Contato : ");
			String contatoInput = mainScanner.nextLine().trim();

			if(nomeInput.isEmpty() || contatoInput.isEmpty()) {
				System.out.println("Nome ou contato invalido.");
				continue;
			}
			else if(clientes.stream().anyMatch(cliente -> 
			cliente.getNomeCompleto().equalsIgnoreCase(nomeInput))) {

				System.out.println("Este cliente já existe.");
				continue;
			}

			clientes.add(new Cliente(nomeInput, contatoInput, clientes.size() + 1));

			System.out.println("Registrar novo Cliente? (s/n)");
			String registar = mainScanner.nextLine();

			registrarNovoCliente = registar.equals("s") ? true : false;

		} while(registrarNovoCliente);

	}

	static class Cliente {

		private String nome;
		private String contato;
		private int id;

		public Cliente(String nome, String contato, int id) {
			this.nome = nome.replaceAll("\\s+", " ").trim();
			this.contato = contato;
			this.id = id;
		}

		public String getPrimeiroNome() {
			return nome.substring(0, nome.indexOf(' ')).trim();
		}
		public String getSegundoNome() {
			return nome.substring(getPrimeiroNome().length(), nome.length()).trim();
		}

		public String getNomeCompleto() {
			return nome;
		}

		public String getContato() {
			return contato;
		}

		public int getID() {
			return this.id;
		}

		public String toString() {
			return "ID : " + getID() + "\nPrimeiro nome : " + getPrimeiroNome() + "\nSegundo nome : " + getSegundoNome();
		}
	}

}
