package it.unical.mat.webcomp21.persistence.dao;


import java.util.List;

import it.unical.mat.webcomp21.model.Scuola;

public interface ScuolaDAO {
	public void save(Scuola scuola);  // Create
	public Scuola findByPrimaryKey(int id);     // Retrieve
	public List<Scuola> findAll();       
	public void update(Scuola scuola); //Update
	public void delete(Scuola scuola); //Delete		
	
}
