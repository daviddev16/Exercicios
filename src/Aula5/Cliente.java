package Aula5;

public class Cliente {

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
