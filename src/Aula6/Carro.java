package Aula6;

import java.util.Random;

public class Carro {

	
	private int numChassi;
	private String placa;
	private float velocidadeAtual;
	private Motorista motorista;
	
	public Carro(String placa, int numChassi, Motorista motorista) {
		this.numChassi = numChassi;
		this.placa = placa;
		velocidadeAtual = 0;

		if(motorista == null) {
			this.motorista = new Motorista("Motorista" + new Random().nextInt(100));
		}
		else {
			this.motorista = motorista;
		}
		
		this.motorista.setCarro(this);
		
	}
	
	public Motorista getMotorista() {
		return motorista;
	}
	
	public void acelerar() {
		acelerar(1);
	}
	
	public void acelerar(int aceleracao) {
		velocidadeAtual += aceleracao;
	}

	public float getVelocidadeAtual() {
		return velocidadeAtual;
	}

	public void setVelocidadeAtual(float velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getNumChassi() {
		return numChassi;
	}

	public void setNumChassi(int numChassi) {
		this.numChassi = numChassi;
	}
	
	
}
