package it.unical.mat.webcomp21.persistence.dao;

import java.util.List;

import it.unical.mat.webcomp21.model.Dipartimento;


public interface DipartimentoDao {
	public void save(Dipartimento dipartimento);  // Create
	public Dipartimento findByPrimaryKey(Long codice);     // Retrieve
	public List<Dipartimento> findAll();       
	public void update(Dipartimento dipartimento); //Update
	public void delete(Dipartimento dipartimento); //Delete	
}
