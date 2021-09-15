package Aula6;

public class Motorista {

	
	private Carro carro;
	private String nome;
	
	public Motorista(String nome) {
		this.nome = nome;
	}
	
	public void acelerar(int aceleracao) {
		if(carro != null) {
			carro.acelerar(aceleracao);
		}
	}

	public String getNome() {
		return nome;
	}
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
}
