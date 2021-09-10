package Aula5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicios {

	private static final String NOME_REGEX = "\b[A-Z]+.+[?^ ][A-Z].{1,19}|\\\\b[A-Z]+.+[?^,][A-Z].{1,19}";
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
			/* inputs */
			System.out.println("======================");
			System.out.println("Registar novo cliente:");

			System.out.println("Nome : ");
			String nomeInput = mainScanner.nextLine().trim();

			System.out.println("Contato : ");
			String contatoInput = mainScanner.nextLine().trim();

			/* validação */
			if(nomeInput.isEmpty() || contatoInput.isEmpty()) {
				System.out.println("Nome ou contato invalido.");
				continue;
			}
			else if(!nomeInput.matches(NOME_REGEX)) {
				System.out.println("Nome invalido.");
				continue;
			}
			else if(clientes.stream().anyMatch(cliente -> 
			cliente.getNomeCompleto().equalsIgnoreCase(nomeInput))) {

				System.out.println("Este cliente já existe.");
				continue;
			}

			/* adicionar o cliente na lista */
			clientes.add(new Cliente(nomeInput, contatoInput, clientes.size() + 1));

			/* registrar novo cliente */
			System.out.println("Registrar novo Cliente? (s/n)");
			String registar = mainScanner.nextLine();

			registrarNovoCliente = registar.equals("s") ? true : false;

		} while(registrarNovoCliente);
	}
}
