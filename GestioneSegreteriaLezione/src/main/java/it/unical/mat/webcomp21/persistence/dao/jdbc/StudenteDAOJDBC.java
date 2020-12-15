package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.rmi.StubNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.mat.webcomp21.model.Studente;
import it.unical.mat.webcomp21.persistence.DBSource;
import it.unical.mat.webcomp21.persistence.dao.StudenteDAO;

public class StudenteDAOJDBC implements StudenteDAO{
	DBSource dbSource;
	
	public StudenteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}
	
	@Override
	public void save(Studente studente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Studente findByPrimaryKey(String matricola) {
		// TODO Auto-generated method stub
		return null;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
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

}
