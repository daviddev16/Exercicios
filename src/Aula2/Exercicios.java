package Aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * David Duarte Pinheiro - Exercicios sobre programação orientada a objetos 2.
 */

@SuppressWarnings("resource")
public class Exercicios {

	/*
	 * Questão 1
	 * Faça um programa para criar N (fornecido pelo usuário) objetos do tipo
	 * Funcionário (matrícula, nome e salário) e solicitar ao usuário que entre com
	 * dados para os N funcionários criados. Ao final imprima os valores fornecidos
	 *  para estes funcionários, juntamente com a média salarial.
	 *  
	 * Questão 2
	 * 2) Crie um novo método construtor para a classe Funcionário de modo que
     * os valores das propriedades sejam fornecidos na criação de um funcionário.
	 * O construtor anterior não pode ser perdido.
	 * 
	 */
	static void questaoUmEDois() {

		Scanner scanner = new Scanner(System.in);
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		boolean continuar = true;

		/* teste
		funcionarios.add(new Funcionario(39201, "A", 9321.35f));
		funcionarios.add(new Funcionario(83929, "B", 9619.12f));
		funcionarios.add(new Funcionario(79621, "C", 9200.42f));
		funcionarios.add(new Funcionario(66931, "D", 4493.63f));
		*/
		
		while (continuar) {
			System.out.println("=-=-=-=-=-=-=-=");
			System.out.println("= Funcionario:  ");

			System.out.println("= Nome:        ");
			String nome = scanner.next();

			System.out.println("= Matricula:  ");
			int matricula = scanner.nextInt();

			System.out.println("= Salario:  ");
			float salario = scanner.nextFloat();

			funcionarios.add(new Funcionario(matricula, nome, salario));

			System.out.println("= Ok.          ");
			System.out.println("= Deseja inserir um novo Funcionario? (true, false)");

			continuar = scanner.nextBoolean();
		}
		
		StringBuffer buffer = new StringBuffer();
		funcionarios.forEach(buffer::append);
		
		float mediaSalarial  = (float)(funcionarios
				.stream()
				.flatMapToDouble(func -> DoubleStream.of(func.getSalario()))
				.reduce((a,b) -> { return a + b; })
				.getAsDouble() / funcionarios.size());
		
		System.out.println("=-=-=-=-=-=-=-=");
		System.out.println("Resultado: ");
		
		System.out.println(buffer.toString());
		System.out.println("Media Salarial: R$" + mediaSalarial);
	}
	

	static class Funcionario {

		private int matricula;
		private String nome;
		private float salario;
		
		public Funcionario(int matricula, String nome, float salario) {
			this.nome = nome;
			this.salario = salario;
			this.matricula = matricula;
		}

		public Funcionario() {
			this.matricula = -1;
			this.salario = -1;
			this.nome = "Invalido.";
		}

		
		public int getMatricula() {
			return matricula;
		}

		public String getNome() {
			return nome;
		}

		public float getSalario() {
			return salario;
		}

		@Override
		public String toString() {
			return "- Nome: " + nome + ", Matricula: " + matricula + ", Salario: " + salario + "\n";
		}

	}

}
