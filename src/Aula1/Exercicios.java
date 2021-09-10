package Aula1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * David Duarte Pinheiro - Exercicios sobre programação orientada a objetos.
 */

@SuppressWarnings("resource")
public class Exercicios {

	/*
	 * Questão 1 
	 * 1) Faça um programa para ler um valor inteiro e que imprima o seu
	 * antecessor e sucessor.
	 */
	static void questaoUm() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Escolha um numero: ");
		int numero = scanner.nextInt();
		System.out.println("Antecessor: " + (numero - 1) + " Sucessor: " + (numero + 1));

	}

	/*
	 * Questão 2 
	 * 2) Faça um programa que receba a quantidade e o valor de 10
	 * produtos. O programa deve calcular e exibir o valor total ao final da
	 * leitura.
	 */
	static void questaoDois() {

		Scanner scanner = new Scanner(System.in);

		final int totalDeProdutos = 10;
		int contador = 0;

		List<Produto> produtos = new ArrayList<>(totalDeProdutos + 1);

		do {
			contador++;

			System.out.println("=-=-=-=-=-=-=-=-=-=");
			System.out.println("= " + contador + "#");

			System.out.println("= Quantidade:      ");
			int quantidade = scanner.nextInt();

			System.out.println("= Valor:           ");
			float valor = scanner.nextFloat();

			produtos.add(new Exercicios.Produto(quantidade, valor));
			System.out.println("= Ok.             ");

		} while (contador < totalDeProdutos);

		int quantidade = 0;
		float valor = 0;

		for (Produto produto : produtos) {
			quantidade += produto.getQuantidade();
			valor += produto.getValor();
		}

		System.out.println("Valor total: " + valor + "R$ \nQuantidade: " + quantidade);

	}

	/*
	 * Questão 3 
	 * 3) Faça um programa que receba a largura e o comprimento de um lote
	 * de terra e mostre a área total existente em metros quadrados.
	 */
	static void questaoTres() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Largura: ");
		float largura = scanner.nextFloat();

		System.out.println("Comprimento: ");
		float comprimento = scanner.nextFloat();

		System.out.println((largura * comprimento) + "m²");

	}

	/*
	 * Questão 4 
	 * 4) Faça um programa para ler três valores decimais que correspondem
	 * aos lados de um triângulo e, depois, se é um triângulo eqüilátero, isóscele
	 * ou escaleno.
	 */
	static void questaoQuatro() {

		Scanner scanner = new Scanner(System.in);

		List<Integer> lados = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			System.out.println("Lado " + (i + 1) + "# : ");
			lados.add(scanner.nextInt());
		}

		int ladosIguais = 1;
		int ultimoLado = -1;

		for (int lado : lados) {
			if (ultimoLado == -1) {
				ultimoLado = lado;
				continue;
			}
			if (lado == ultimoLado) {
				ladosIguais++;
			}
		}

		switch (ladosIguais) {
		case 1:
			System.out.println("Escaleno");
			break;
		case 2:
			System.out.println("isósceles");
			break;
		case 3:
			System.out.println("Equilátero");
			break;
		}

	}

	/*
	 * Questão 5 
	 * 5) Crie um programa que imprima os ímpares de 1 até N, sendo N
	 * solicitado ao usuário.
	 */
	static void questaoCinco() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Numero: ");
		int numero = scanner.nextInt();

		System.out.println("\n");
		for (int i = 1; i < numero; i++) {
			if ((i % 2) == 1) {
				System.out.print(i + " ");
			}
		}

	}

	/*
	 * Questão 6 
	 * 6) Faça um programa que solicite dois valores e imprima todos os
	 * pares entre o menor valor e o maior valor. Caso os números digitados sejam
	 * iguais, enviar mensagem ao usuário e imprimir os pares de 1 a 10 como
	 * exemplo.
	 */
	static void questaoSeis() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Inicio : ");
		int valorInicial = scanner.nextInt();

		System.out.println("Fim : ");
		int valorFinal = scanner.nextInt();

		if (valorInicial > valorFinal) {
			System.out.println("Valor inicial deve ser menor que o valor final.");
			return;
		} else if (valorInicial == valorFinal) {
			System.out.println("Valor inicial não pode ser igual ao valor final.");
			return;
		}

		/* x = a + (b - a) */
		for (int x = valorInicial; x <= valorInicial + (valorFinal - valorInicial); x++) {
			if (x % 2 == 0) {
				System.out.print(x + " ");
			}
		}

	}

	/*
	 * Questão 7 
	 * 7) Faça um programa que leia N nomes de alunos e suas médias finais
	 * – sendo N informado pelo usuário – e que, ao final, forneça o percentual de
	 * alunos aprovados (média >= 6) e também os nomes e médias desses alunos.
	 */
	static void questaoSete() {

		Scanner scanner = new Scanner(System.in);

		List<Aluno> alunos = new ArrayList<>();

		/*
		 * teste
		 * alunos.add(new Aluno("A", 6.5f)); 
		 * alunos.add(new Aluno("B", 3.1f));
		 * alunos.add(new Aluno("C", 6.7f)); 
		 * alunos.add(new Aluno("D", 2.4f));
		 * alunos.add(new Aluno("E", 8.3f));
		 */
		boolean continuar = true;

		while (continuar) {

			System.out.println("=-=-=-=-=-=-=-=");
			System.out.println("= Novo aluno:  ");

			System.out.println("= Nome:        ");
			String nome = scanner.next();

			System.out.println("= MediaFinal:  ");
			float mediaFinal = scanner.nextFloat();

			alunos.add(new Aluno(nome, mediaFinal));

			System.out.println("= Ok.          ");
			System.out.println("= Deseja inserir um novo aluno? (true, false)");

			continuar = scanner.nextBoolean();
		}

		Object[] listaAlunosAprovados = alunos.stream().filter(aluno -> aluno.getMediaFinal() >= 6).toArray();

		StringJoiner alunosAprovados = new StringJoiner(", ");
		Arrays.stream(listaAlunosAprovados).forEach(aluno -> alunosAprovados.add(((Aluno) aluno).getNome()));

		float porcentagemDeAlunosAprovados = (listaAlunosAprovados.length / (float) alunos.size()) * 100;

		System.out.println("\n\n=-=-=-=-=-=-=-=-=-");
		System.out.println("Total de Alunos Aprovados: " + listaAlunosAprovados.length + "/" + alunos.size());
		System.out.println("Percentual de Alunos Aprovados: " + Math.round(porcentagemDeAlunosAprovados) + "%");
		System.out.println("Alunos Aprovados: " + alunosAprovados.toString());
		System.out.println("=-=-=-=-=-=-=-=-=-");

	}

	/*
	 * Questão 8 
	 * 8) Crie um programa que apresente o fatorial de um número N
	 * informado pelo usuário.
	 */
	static void questaoOito() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Numero: ");
		int numero = scanner.nextInt();
		System.out.println("Fatorial: " + fatorial(numero));

	}

	/*
	 * Questão 9 
	 * 9) Faça um programa que receba uma frase qualquer e mostre-a
	 * invertida como no exemplo abaixo:
	 */
	static void questaoNove() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Frase: ");
		String frase = scanner.nextLine();
		System.out.println("Invertida: " + reverseString(frase));

	}

	/*
	 * Questão 10 
	 * 10) Faça um programa que solicite um valor de 1 a 12
	 * correspondendo a um mês do ano, e imprima o nome do mês por extenso. Trate as
	 * entradas inadequadas.
	 */
	static void questaoDez() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Valor do mês: ");
		int valor = scanner.nextInt();

		if (valor < 1 || valor > 12) {
			System.out.println("Insira um valor valido. (1 - 12)");
			return;
		}

		List<String> mesesDoAno = Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
				"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");

		System.out.println("Mês: " + mesesDoAno.get(valor - 1));
	}

	/* Metodo usado na questão 8 */
	static int fatorial(int num) {
		if (num <= 1) {
			return 1;
		}
		return (num * fatorial(num - 1));
	}

	/* Metodo usado na questão 9 */
	static String reverseString(String str) {

		char[] textoReverso = new char[str.length()];
		for (int i = textoReverso.length - 1; i >= 0; i--) {
			textoReverso[textoReverso.length - 1 - i] = str.toCharArray()[i];
		}

		return new String(textoReverso);
	}

	/* Classe usada na questão 7 */
	static class Aluno {

		private String nome;
		private float mediaFinal;

		public Aluno(String nome, float mediaFinal) {
			this.mediaFinal = mediaFinal;
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}

		public float getMediaFinal() {
			return mediaFinal;
		}

	}

	/* Classe usada na questão 2 */
	static class Produto {

		private int quantidade;
		private float valor;

		public Produto(int quantidade, float valor) {
			this.quantidade = quantidade;
			this.valor = valor;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public float getValor() {
			return valor;
		}

	}

}
