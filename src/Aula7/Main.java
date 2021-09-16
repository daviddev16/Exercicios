package Aula7;

public class Main {

	public static void main(String[] args) {
		
		Pessoa motorista = new Motorista("Motorista1", "ABC");
		Pessoa passageiro = new Passageiro("Passageiro1", "ABC");
		
		if(motorista instanceof Pessoa && passageiro instanceof Pessoa) {
			System.out.println("Ambos são pessoas!");
		}
		
	}
	
}
