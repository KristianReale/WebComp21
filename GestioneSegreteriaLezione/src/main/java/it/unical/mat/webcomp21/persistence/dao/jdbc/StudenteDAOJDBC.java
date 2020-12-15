package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.rmi.StubNotFoundException;
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
import it.unical.mat.webcomp21.persistence.dao.StudenteDAO;

public class StudenteDAOJDBC implements StudenteDAO{
	DBSource dbSource;
	
	public StudenteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}
	
	@Override
	public void save(Studente studente) {
		Connection conn;
		try {
			conn = dbSource.getConnection();
			String queryUpdate = "INSERT INTO studente values(?, ?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(queryUpdate);
			st.setString(1, studente.getMatricola());
			st.setString(2, studente.getNome());
			st.setString(3, studente.getCognome());
			st.setString(4, studente.getDataNascita());
			st.setLong(5, studente.getScuola().getId());
			
			CorsoDiLaurea cdl = dammiCorsoDiLaureaDiStudente(studente);
			st.setLong(6, cdl.getId());		
			
			st.executeUpdate();					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Studente findByPrimaryKey(String matricola) {
		Studente studente = null;
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from studente where matricola=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String matr = rs.getString("matricola");
				String cogn = rs.getString("cognome");
				String nome = rs.getString("nome");
				String dataNascita = rs.getString("datanascita");
				
				studente = new Studente();
				studente.setNome(nome);
				studente.setCognome(cogn);
				studente.setMatricola(matr);
				studente.setDataNascita(dataNascita);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studente;
	}

	@Override
	public List<Studente> findAll() {
		List<Studente> studenti = new ArrayList<Studente>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from studente";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String matr = rs.getString("matricola");
				String cogn = rs.getString("cognome");
				String nome = rs.getString("nome");
				String dataNascita = rs.getString("datanascita");
				
				Studente stud = new Studente();
				stud.setNome(nome);
				stud.setCognome(cogn);
				stud.setMatricola(matr);
				stud.setDataNascita(dataNascita);
				
				studenti.add(stud);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studenti;
	}

	@Override
	public void update(Studente studente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Studente studente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoDiLaurea dammiCorsoDiLaureaDiStudente(Studente studente) {
		List<CorsoDiLaurea> cdls = DBManager.getInstance().corsoDiLaureaDAO().findAll();
		for (CorsoDiLaurea cdl : cdls) {
			for (Studente s : cdl.getStudenti()) {
				if (s.getMatricola().equals(studente.getMatricola())){
					return cdl;
				}
			}
		}
		return null;
	}

}
