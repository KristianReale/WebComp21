package it.unical.mat.webcomp21.persistence;

import java.util.List;

import it.unical.mat.webcomp21.model.Studente;
import it.unical.mat.webcomp21.persistence.dao.CorsoDiLaureaDAO;
import it.unical.mat.webcomp21.persistence.dao.StudenteDAO;
import it.unical.mat.webcomp21.persistence.dao.jdbc.CorsoDiLaureaDAOJDBC;
import it.unical.mat.webcomp21.persistence.dao.jdbc.StudenteDAOJDBC;

public class DBManager {
	private static DBManager instance = null;
	static DBSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			//questi vanno messi in file di configurazione!!!	
			dataSource=new DBSource("jdbc:postgresql://localhost:5432/Nuovo","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
	}
	
	public static DBSource getDataSource() {
		return dataSource;
	}
	
	public StudenteDAO studenteDAO() {
		return new StudenteDAOJDBC(dataSource);
	}
	
	public CorsoDiLaureaDAO corsoDiLaureaDAO() {
		return new CorsoDiLaureaDAOJDBC(dataSource);
	}

}
