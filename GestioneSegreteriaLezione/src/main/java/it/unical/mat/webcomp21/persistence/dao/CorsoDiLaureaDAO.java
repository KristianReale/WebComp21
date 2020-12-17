package it.unical.mat.webcomp21.persistence.dao;


import java.util.ArrayList;
import java.util.List;

import it.unical.mat.webcomp21.model.CorsoDiLaurea;
import it.unical.mat.webcomp21.model.Studente;

public interface CorsoDiLaureaDAO {
	public void save(CorsoDiLaurea cdl);  // Create
	public CorsoDiLaurea findByPrimaryKey(int id);     // Retrieve
	public List<CorsoDiLaurea> findAll();       
	public void update(CorsoDiLaurea cdl); //Update
	public void delete(CorsoDiLaurea cdl); //Delete	
	
	
	public ArrayList<Studente> findStudentiByCorsoDiLaureaId(int id);
}
