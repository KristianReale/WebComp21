package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.mat.webcomp21.model.CorsoDiLaurea;
import it.unical.mat.webcomp21.model.Studente;
import it.unical.mat.webcomp21.persistence.DBManager;
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
	public ArrayList<Studente> findStudentiByCorsoDiLaureaId(int cdlId) {
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from studente where corsodilaurea = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, cdlId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String matr = rs.getString("matricola");
				String cogn = rs.getString("cognome");
				String nome = rs.getString("nome");
				String dataNascita = rs.getString("datanascita");
				int scuolaId = rs.getInt("scuola");
				
				Studente stud = new Studente();
				stud.setNome(nome);
				stud.setCognome(cogn);
				stud.setMatricola(matr);
				stud.setDataNascita(dataNascita);
				stud.setScuola(DBManager.getInstance().scuolaDAO().findByPrimaryKey(scuolaId));				
				
				studenti.add(stud);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studenti;
	}

	@Override
	public List<CorsoDiLaurea> findAll() {
		List<CorsoDiLaurea> cdls = new ArrayList<CorsoDiLaurea>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from corsodilaurea";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				
				CorsoDiLaurea cdl = new CorsoDiLaurea();
				cdl.setId(id);
				cdl.setNome(nome);
				cdl.setStudenti(DBManager.getInstance().corsoDiLaureaDAO().findStudentiByCorsoDiLaureaId(id)); 
				
				cdls.add(cdl);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cdls;
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
