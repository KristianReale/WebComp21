package it.unical.mat.webcomp21.segreteria;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.DBManager;

public class TestDB {
	public static void main(String[] args) {
		try {
			Connection conn = DBManager.getInstance().getDataSource().getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
