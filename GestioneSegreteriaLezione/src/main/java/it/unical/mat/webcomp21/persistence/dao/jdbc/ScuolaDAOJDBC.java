package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.unical.mat.webcomp21.model.Scuola;
import it.unical.mat.webcomp21.persistence.DBSource;
import it.unical.mat.webcomp21.persistence.dao.ScuolaDAO;

public class ScuolaDAOJDBC implements ScuolaDAO {
	DBSource dbSource;
	
	public ScuolaDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}
	
	@Override
	public void save(Scuola scuola) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scuola findByPrimaryKey(int id) {
		Scuola scuola = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from scuola where id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int idS = rs.getInt("id");
				String codMecc = rs.getString("codicemeccanografico");
				String nome = rs.getString("nome");
				
				scuola = new Scuola();
				scuola.setId(idS);
				scuola.setCodiceMeccanografico(codMecc);
				scuola.setNome(nome);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return scuola;
	}

	@Override
	public List<Scuola> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Scuola scuola) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Scuola scuola) {
		// TODO Auto-generated method stub
		
	}

}
