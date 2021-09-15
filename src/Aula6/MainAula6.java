package Aula6;

public class MainAula6 {

	
	public static void main(String[] args) {
		
		
		Carro carro = new Carro("ABC3521", 3925201, new Motorista("Motorista_1"));

		carro.getMotorista().acelerar(5);
		carro.getMotorista().acelerar(-5);
		carro.getMotorista().acelerar(10);
		
		System.out.println("Motorista: " + carro.getMotorista().getNome());
		System.out.println("Placa: " + carro.getPlaca());
		System.out.println("Velocidade: " + carro.getVelocidadeAtual() + "km/h");
		
	}
	
}
