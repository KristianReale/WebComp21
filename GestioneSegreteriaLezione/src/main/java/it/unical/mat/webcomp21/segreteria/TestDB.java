package it.unical.mat.webcomp21.segreteria;

import java.util.List;

import model.Studente;
import persistence.DBManager;
import persistence.dao.StudenteDAO;

public class TestDB {
	public static void main(String[] args) {
		StudenteDAO sDao = DBManager.getInstance().studenteDAO();
		List<Studente> studenti = sDao.findAll();
		for (Studente s : studenti) {
			System.out.println(s.getCognome());
			System.out.println(s.getNome());
		}
		
	}
}
