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

	public String[] nomeSeparado() {
		return nome.split("\\s+");
	}

	public String getPrimeiroNome() {
		if(nomeSeparado().length > 1) {
			return nome.substring(0, nome.indexOf(' ')).trim();	
		}			
		return nome;
	}

	public String getSegundoNome() {
		if(nomeSeparado().length > 1) {
			return nome.substring(getPrimeiroNome().length(), nome.length()).trim();
		}
		return "";
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
