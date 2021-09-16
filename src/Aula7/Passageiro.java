package Aula7;

public final class Passageiro extends Pessoa {

	private int codigoCliente;
	
	public Passageiro(String nome, String cpf) {
		super(nome, cpf);
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	

}
