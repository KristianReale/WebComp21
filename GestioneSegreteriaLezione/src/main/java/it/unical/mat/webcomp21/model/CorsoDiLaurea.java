package it.unical.mat.webcomp21.model;

import java.util.ArrayList;

public class CorsoDiLaurea {
	int id;
	String nome;
	ArrayList<Studente> studenti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<Studente> studenti) {
		this.studenti = studenti;
	}
}
