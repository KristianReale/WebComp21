package model;

public class Studente {
	String matricola;
	String cognome;
	String nome;
	String dataNascita;
	Scuola scuola;		
	
	public Scuola getScuola() {
		return scuola;
	}
	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}
	
	public String getMatricola() {
		return matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public String getNome() {
		return nome;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
}
