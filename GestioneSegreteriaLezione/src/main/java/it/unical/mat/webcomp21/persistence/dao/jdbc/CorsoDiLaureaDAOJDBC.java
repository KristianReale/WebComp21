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

	public void save(CorsoDiLaurea corsoDiLaurea) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			Long id = IdBroker.getId(connection);
			corsoDiLaurea.setId(id); 
			String insert = "insert into corsodilaurea(id, nome) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, corsoDiLaurea.getId());
			statement.setString(2, corsoDiLaurea.getNome());

			statement.executeUpdate();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					throw new RuntimeException(e.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	@Override
	public CorsoDiLaurea findByPrimaryKey(Long id) {
		CorsoDiLaurea corsoDiLaurea = null;
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			PreparedStatement statement;
			String query = "select * from corsodilaurea where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				corsoDiLaurea = new CorsoDiLaurea();
				corsoDiLaurea.setId(result.getLong("id"));				
				corsoDiLaurea.setNome(result.getString("nome"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}	
		return corsoDiLaurea;
	}
	
	@Override
	public ArrayList<Studente> findStudentiByCorsoDiLaureaId(Long cdlId) {
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from studente where corsodilaurea = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, cdlId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String matr = rs.getString("matricola");
				String cogn = rs.getString("cognome");
				String nome = rs.getString("nome");
				String dataNascita = rs.getString("datanascita");
				Long scuolaId = rs.getLong("scuola");
				
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
				Long id = rs.getLong("id");
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

	public void update(CorsoDiLaurea corsodilaurea) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String update = "update corso SET nome = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, corsodilaurea.getNome());
			statement.setLong(2, corsodilaurea.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					throw new RuntimeException(e.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public void delete(CorsoDiLaurea corsoDiLaurea) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String delete = "delete FROM corsodilaurea WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, corsoDiLaurea.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	
}
