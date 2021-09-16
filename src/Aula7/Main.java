package Aula7;

public class Main {

	public static void main(String[] args) {
		
		Motorista motorista = new Motorista("Motorista1", "ABC");
		motorista.setHabilitacao("2191ABC");
		motorista.setMatricula(291002);
		
		Passageiro passageiro = new Passageiro("Passageiro1", "ABC");
		passageiro.setCodigoCliente(2910429);
		
		if(motorista instanceof Pessoa && passageiro instanceof Pessoa) {
			System.out.println("Ambos são pessoas!");
		}
		
	}
	
}
