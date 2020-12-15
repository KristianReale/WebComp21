package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.util.List;

import it.unical.mat.webcomp21.model.CorsoDiLaurea;
import it.unical.mat.webcomp21.persistence.DBSource;
import it.unical.mat.webcomp21.persistence.dao.CorsoDiLaureaDAO;

public class CorsoDiLaureaDAOJDBC implements CorsoDiLaureaDAO{
	DBSource dbSource;
	
	public CorsoDiLaureaDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(CorsoDiLaurea cdl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoDiLaurea findByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CorsoDiLaurea> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CorsoDiLaurea cdl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CorsoDiLaurea cdl) {
		// TODO Auto-generated method stub
		
	}
	
	
}
