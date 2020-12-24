package it.unical.mat.webcomp21.model;

public class Scuola {
	Long id;
	String codiceMeccanografico;
	String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodiceMeccanografico() {
		return codiceMeccanografico;
	}
	public void setCodiceMeccanografico(String codiceMeccanografico) {
		this.codiceMeccanografico = codiceMeccanografico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
