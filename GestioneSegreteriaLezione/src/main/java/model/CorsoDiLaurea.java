package model;

import java.util.ArrayList;

public class CorsoDiLaurea {
	int id;
	String nome;
	ArrayList<Studente> studenti;
	
//	HashMap<String, Studente> studenti;
	
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
}
