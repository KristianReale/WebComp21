package it.unical.mat.webcomp21.model;

import java.util.ArrayList;

public class CorsoDiLaurea {
	Long id;
	String nome;
	ArrayList<Studente> studenti;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
