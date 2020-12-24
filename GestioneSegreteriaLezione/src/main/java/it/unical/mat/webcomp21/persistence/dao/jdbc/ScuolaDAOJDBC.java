package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unical.mat.webcomp21.model.Scuola;
import it.unical.mat.webcomp21.persistence.DBSource;
import it.unical.mat.webcomp21.persistence.dao.ScuolaDAO;

public class ScuolaDAOJDBC implements ScuolaDAO {
	private DBSource dbSource;

	public ScuolaDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	public void save(Scuola scuola) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			Long id = IdBroker.getId(connection);
			scuola.setId(id); 			
			String insert = "insert into scuola(id, codicemeccanografico, nome) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, scuola.getId());
			statement.setString(2, scuola.getCodiceMeccanografico());
			statement.setString(3, scuola.getNome());

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

	/* 
	 * versione con Lazy Load
	 */
	public Scuola findByPrimaryKey(Long id) {
		Connection connection = null;
		Scuola scuola = null;
		try {
			connection = this.dbSource.getConnection();
			PreparedStatement statement;
			String query = "select * from scuola where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				scuola = new Scuola();
				scuola.setId(result.getLong("id"));				
				scuola.setNome(result.getString("nome"));
				scuola.setCodiceMeccanografico(result.getString("codicemeccanografico"));
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
		return scuola;
	}

	public List<Scuola> findAll() {
		Connection connection = null;
		List<Scuola> scuole = new ArrayList<>();
		try {
			connection = this.dbSource.getConnection();
			Scuola scuola;
			PreparedStatement statement;
			String query = "select * from scuola";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				scuola = new Scuola();
				scuola.setId(result.getLong("id"));				
				scuola.setNome(result.getString("nome"));
				scuola.setCodiceMeccanografico(result.getString("codicemeccanografico"));
				scuole.add(scuola);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return scuole;
	}

	public void update(Scuola scuola) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String update = "update gruppo SET nome = ?, codice_meccanografico = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, scuola.getNome());
			statement.setLong(3, scuola.getId());

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

	public void delete(Scuola scuola) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String delete = "delete FROM scuola WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, scuola.getId());

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
