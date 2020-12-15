package it.unical.mat.webcomp21.persistence.dao;


import java.util.List;

import it.unical.mat.webcomp21.model.Studente;

public interface StudenteDAO {
	public void save(Studente studente);  // Create
	public Studente findByPrimaryKey(String matricola);     // Retrieve
	public List<Studente> findAll();       
	public void update(Studente studente); //Update
	public void delete(Studente studente); //Delete	
}
